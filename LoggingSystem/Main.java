package LoggingSystem;

public class Main {

    public static void main(String args[]) {
        LogProcessor logger = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));

        logger.log(LogProcessor.ERROR, "Some exception occurred");
        logger.log(LogProcessor.DEBUG, "Todo: Debug this ");
        logger.log(LogProcessor.INFO, "Just for info");
    }
}
