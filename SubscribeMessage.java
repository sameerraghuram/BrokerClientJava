/**
 * Created by sameerraghuram on 4/22/17.
 */
public class SubscribeMessage extends Message{

    String EXCHANGE_NAME;
    String QUEUE_NAME;
    String SUBSCRIBER_NAME;

    public SubscribeMessage(String exchangeName, String queueName){
        super(Consts.REQ_ADD_SUBSCRIBER);
        this.QUEUE_NAME = queueName;
        this.EXCHANGE_NAME = exchangeName;
        try {
            this.SUBSCRIBER_NAME = IpChecker.getIp();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SubscribeMessage(String queueName){
        this("default", queueName);
    }
}
