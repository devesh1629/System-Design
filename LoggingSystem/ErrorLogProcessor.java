package LoggingSystem;

public class ErrorLogProcessor extends LogProcessor {

    public ErrorLogProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

    public void log(int logLevel, String logMessage) {
        if(logLevel == ERROR) {
            System.out.println("ERROR: " + logMessage);
        }
        else
            super.log(logLevel, logMessage);
    }
}
