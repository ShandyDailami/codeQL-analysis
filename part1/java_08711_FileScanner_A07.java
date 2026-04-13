import java.io.File;
import java.util.Scanner;

public class java_08711_FileScanner_A07 {
    public static void main(String[] args) {
        // Specify the directory to scan
        String directoryPath = "/path/to/directory";
        File directory = new File(directoryPath);

        // Scan the directory for files
        File[] files = directory.listFiles();

        // If there are no files, print a message and exit
        if (files == null) {
            System.out.println("No files in directory");
            System.exit(0);
        }

        // Print the names and sizes of the files
        for (File file : files) {
            System.out.println("File: " + file.getName());
        }
    }
}