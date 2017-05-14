/**
 * Created by sameerraghuram on 4/22/17.
 */
public class Consts {
    static String MSG_HEADER_LABEL = "HEADER";
    static String MSG_HEADER_REQUEST_LABEL = "REQUEST";
    static String MSG_HEADER_CLIENT_LABEL = "CLIENT";

    static String REQ_CREATE_QUEUE = "CREATE_QUEUE";
    static String REQ_CREATE_EXCHAGE = "CREATE_EXCHANGE";
    static String REQ_ADD_SUBSCRIBER = "ADD_SUBSCRIBER";
    static String REQ_ADD_MESSGAE  = "ADD_MESSAGE";
    static String REQ_EXISTS_EXCHANGE = "EXISTS_EXCHANGE";
    static String REQ_EXISTS_QUEUE = "EXISTS_QUEUE";

    static String INFO_NAME_EXCHANGE = "EXCHANGE_NAME";
    static String INFO_TYPE_EXCHANGE = "EXCHANGE_TYPE";
    static String INFO_NAME_QUEUE = "QUEUE_NAME";
    static String INFO_NAME_SUBSCRIBER = "SUBSCRIBER_NAME";
    static String INFO_NAME_MESSAGE = "PUBLISH_MESSAGE";

    static String OPTION_ACKNOWLEDGE_LABEL = "ACKNOWLEDGE";
    static String OPTION_ACKNOWLEDGE_TRUE = "TRUE";
    static String OPTION_ACKNOWLEDGE_FALSE = "FALSE";

    static String TYPE_EXCHANGE_DIRECT = "DIRECT";
    static String TYPE_EXCHANGE_FANOUT = "FANOUT";
}
