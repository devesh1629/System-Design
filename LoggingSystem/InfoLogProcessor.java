package LoggingSystem;

public class InfoLogProcessor extends LogProcessor {

    public InfoLogProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

    public void log(int logLevel, String logMessage) {
        if(logLevel == INFO) {
            System.out.println("INFO: " + logMessage);
        }
        else
            super.log(logLevel, logMessage);
    }
}
