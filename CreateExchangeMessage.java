/**
 * Created by sameerraghuram on 4/22/17.
 */
public class CreateExchangeMessage extends Message{

    String EXCHANGE_NAME;

    public CreateExchangeMessage(String exchangeName){
        super(Consts.REQ_CREATE_EXCHAGE);
        this.EXCHANGE_NAME = exchangeName;
    }
}
