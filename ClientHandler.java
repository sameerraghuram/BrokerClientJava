import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by sameerraghuram on 4/25/17.
 */
public class ClientHandler implements Runnable {
    Socket clientSocket;
    Callbacks callbacks;

    public ClientHandler(Socket clientSocket){
        this.clientSocket = clientSocket;
        this.callbacks = Callbacks.getInstance();
    }


    @Override
    public void run() {

        // Buffer
        byte[] buf = new byte[1024];

        try {
            BufferedInputStream bis = new BufferedInputStream(clientSocket.getInputStream());
            ByteArrayOutputStream byos = new ByteArrayOutputStream();

            // Read bytes from the socket input stream in 1024 increments
            // Untill we reach EOF
            while(bis.read(buf, 0, buf.length) != -1){
                // Write bytes to a op stream
                byos.write(buf, 0, buf.length);
            }

            // Capture the byte array as a string
            String message = byos.toString("utf-8").trim();

            // Convert String to JSON
            Gson gson = new GsonBuilder().setPrettyPrinting().setLenient().create();

            System.out.println(message);
            Message messageJSON = gson.fromJson(message, Message.class);

            if(messageJSON.HEADER.REQUEST.equals(Consts.REQ_ADD_MESSGAE)){
                PublishMessage publishMessage = gson.fromJson(message, PublishMessage.class);

                String queueName = publishMessage.QUEUE_NAME;
                String exchangeName = publishMessage.EXCHANGE_NAME;
                String key = exchangeName.equals("default") ? queueName : exchangeName + "." + queueName;

                callbacks.exec(key, publishMessage.PUBLISH_MESSAGE);

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
