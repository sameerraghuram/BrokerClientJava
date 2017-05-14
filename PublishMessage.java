/**
 * Created by sameerraghuram on 4/22/17.
 */
public class PublishMessage extends Message{

    String EXCHANGE_NAME;
    String QUEUE_NAME;
    String PUBLISH_MESSAGE;

    public PublishMessage(String exchangeName, String queueName, String message){
        super(Consts.REQ_ADD_MESSGAE);
        this.QUEUE_NAME = queueName;
        this.EXCHANGE_NAME = exchangeName;
        this.PUBLISH_MESSAGE = message;
    }

    public PublishMessage(String queueName, String message){
        this("default", queueName, message);
    }
}
