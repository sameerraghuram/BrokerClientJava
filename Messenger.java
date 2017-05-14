import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.Buffer;

/**
 * Created by sameerraghuram on 4/25/17.
 */
public class Messenger {

    InetAddress address;
    int port;
    Socket sendSocket;
    OutputStream outputStream = null;
    BufferedOutputStream bufferedOutputStream = null;

    public Messenger(String address, int port) throws IOException {
        this(InetAddress.getByName(address), port);
    }

    public Messenger(InetAddress address, int port) throws IOException {
        this.address = address;
        this.port = port;
        sendSocket = new Socket(this.address, this.port);
    }

    public void sendMessage(String message) throws IOException {
        // Step 1: Convert String to byte-array
        byte[] messageBytes = message.getBytes();

        // Step 2: Send byte-array
        sendMessage(messageBytes);
    }

    public void sendMessage(byte[] message) throws IOException {

        try {
            // Step 1: Get socket OutputStream
            outputStream = sendSocket.getOutputStream();
            bufferedOutputStream = new BufferedOutputStream(outputStream);

            // Step 2: Write and flush
            bufferedOutputStream.write(message, 0, message.length);
            bufferedOutputStream.flush();
            System.out.printf("Done\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            // Close everthing
            if(bufferedOutputStream != null)
                bufferedOutputStream.close();

            if(outputStream != null)
                outputStream.close();

        }
    }
}
