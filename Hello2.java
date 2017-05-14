import java.util.function.Consumer;

/**
 * Created by sameerraghuram on 4/25/17.
 */
public class Hello2 {
    public static void main(String[] args) {
        Connection conn = new Connection("newavalon.cs.rit.edu");
        conn.createQueue("Test");
        conn.subscribe("Test", String::toLowerCase);
    }
}
