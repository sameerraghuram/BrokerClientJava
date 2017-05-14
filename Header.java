import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by sameerraghuram on 4/22/17.
 */
public class Header {

    String REQUEST;
    String CLIENT;

    public Header(String request){
        this.REQUEST = request;
        try {
            this.CLIENT = IpChecker.getIp();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Header(String request, String client){
        this.REQUEST = request;
        this.CLIENT = client;
    }

    public static void main(String[] args) {
        try {
            System.out.println(IpChecker.getIp());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
