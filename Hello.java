/**
 * Created by sameerraghuram on 4/21/17.
 */
public class Hello {
    public static void main(String[] args) {
        // Create a connection
        Connection conn = new Connection("newavalon.cs.rit.edu");

        // Create the chat queue
        conn.createQueue("sample_queue");

        // Subscribe by providing a lambda function as callback !
        conn.subscribe("sample_queue", msg -> System.out.println("Received" + msg));

        // Publish a message to the queue
        conn.publish("Test", "Hello World!");

    }
}