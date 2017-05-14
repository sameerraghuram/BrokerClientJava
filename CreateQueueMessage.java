/**
 * Created by sameerraghuram on 4/22/17.
 */
public class CreateQueueMessage extends Message{

    String EXCHANGE_NAME;
    String QUEUE_NAME;

    public CreateQueueMessage(String exchangeName, String queueName){
        super(Consts.REQ_CREATE_QUEUE);
        this.QUEUE_NAME = queueName;
        this.EXCHANGE_NAME = exchangeName;
    }

    public CreateQueueMessage(String queueName){
        this("default", queueName);
    }
}
