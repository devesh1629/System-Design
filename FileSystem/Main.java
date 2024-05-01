package FileSystem;

public class Main {

    public static void main(String args[]) {
        Directory filesDirectory = new Directory("projects");
        FileSystem fileName1 = new File("Project1");
        FileSystem fileName2 = new File("Project2");
        filesDirectory.add(fileName1);
        filesDirectory.add(fileName2);

        Directory logsDirectory = new Directory("logs");
        File logfile = new File("log1");
        logsDirectory.add(logfile);
        filesDirectory.add(logsDirectory);

        filesDirectory.ls();

    }
}
