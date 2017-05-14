import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by sameerraghuram on 4/22/17.
 */
public class ClientListener implements Runnable{

    Socket clientSocket = null;

    /**
     * Sets up and configures a listner on the client
     * port for our application (12343).
     *
     * New connections are handled by the run method.
     */
    public void run() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(12343);

            while (true) {
                clientSocket = serverSocket.accept();
                System.out.println("Accepted Connection from"+clientSocket.getInetAddress().getCanonicalHostName());
                Thread handler = new Thread(new ClientHandler(clientSocket));
                handler.start();
            }
        }
        catch (IOException io){
            System.err.println("IOExceotion has occured: "+io.getMessage());
        }
        finally {
            System.out.printf("Clean up here");
        }
    }
}
