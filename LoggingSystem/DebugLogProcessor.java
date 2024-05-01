package LoggingSystem;

public class DebugLogProcessor extends LogProcessor {

    public DebugLogProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

    public void log(int logLevel, String logMessage) {
        if(logLevel == DEBUG) {
            System.out.println("DEBUG: " + logMessage);
        }
        else
            super.log(logLevel, logMessage);
    }
}
