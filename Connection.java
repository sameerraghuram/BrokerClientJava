/**
 * Created by sameerraghuram on 4/22/17.
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.function.Consumer;

/**
 * TODO: Write a relaible function to send JSON messages
 * TODO: Write a Server (Done)
 * TODO: Figure out how GSON works
 */

public class Connection {

    String broker;
    ClientListener clientListener;
    Callbacks callbacks;

    public Connection(String broker){
        this.broker = broker;
        clientListener = new ClientListener();
        callbacks = Callbacks.getInstance();
        Thread listener = new Thread(clientListener);
        listener.start();

    }

    /**
     * Sends a request to the Broker to subscribe the client
     * to a message queue residing on the default exchange.
     *
     * @param queueName: ID of the message queue on the broker
     * @param callback: Function to be called everytime a new message arrives.
     */
    public void subscribe(String queueName, Consumer<String> callback){
        // Construct the request here

        // Step 1: Make the GSON object
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // Step 2: Create the request JSON string
        SubscribeMessage subscribeMessage = new SubscribeMessage(queueName);
        String message = gson.toJson(subscribeMessage);

        // Step 3: Register callback to queue-id
        this.callbacks.put(queueName, callback);

        // Step 4: Send message
        try {
            Messenger messenger = new Messenger(this.broker, 12344);
            messenger.sendMessage(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Sends a request to the Broker to subscribe the client
     * to a message queue residing on the exchange given by exchangeName.
     *
     * @param exchangeName: Identity of the exchange
     * @param queueName: ID of the message queue on the broker
     * @param callback: Function to be called everytime a new message arrives.
     */
    public void subscribe(String exchangeName, String queueName, Consumer<String> callback){
        // Step 1: Make the GSON object
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // Step 2: Create the request JSON string
        SubscribeMessage subscribeMessage = new SubscribeMessage(exchangeName, queueName);
        String message = gson.toJson(subscribeMessage);

        // Step 3: Register callback to queue-id
        this.callbacks.put(exchangeName + "." + queueName, callback);

        // TODO: Step 4: Send message
        try {
            Messenger messenger = new Messenger(this.broker, 12344);
            messenger.sendMessage(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void createQueue(String exchangeName, String queueName){
        // Step 1: Make the GSON object
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // Step 2: Create the request JSON string
        CreateQueueMessage createQueueMessage = new CreateQueueMessage(exchangeName, queueName);
        String message = gson.toJson(createQueueMessage);

        // Step 3: Send message
        try {
            Messenger messenger = new Messenger(this.broker, 12344);
            messenger.sendMessage(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createQueue(String queueName){
        // Step 1: Make the GSON object
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // Step 2: Create the request JSON string
        CreateQueueMessage createQueueMessage = new CreateQueueMessage(queueName);
        String message = gson.toJson(createQueueMessage);

        // Step 3: Send message
        try {
            Messenger messenger = new Messenger(this.broker, 12344);
            messenger.sendMessage(message);
            //System.out.println(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void publish(String queueName, String message){
        // Step 1: Make the GSON object
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // Step 2: Create the request JSON string
        PublishMessage publishMessage = new PublishMessage(queueName, message);
        message = gson.toJson(publishMessage);

        // TODO: Step 4: Send message
        try {
            Messenger messenger = new Messenger(this.broker, 12344);
            messenger.sendMessage(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
