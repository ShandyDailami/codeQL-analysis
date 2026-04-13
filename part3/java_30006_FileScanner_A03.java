import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_30006_FileScanner_A03 {
    public static void main(String[] args) {
        // Create a FileScanner object with a specific directory
        FileScanner fileScanner = new FileScanner("/path/to/directory");
        
        // Use the scan method to read files from the directory
        fileScanner.scan();
    }
}

class FileScanner {
    private File directory;

    public java_30006_FileScanner_A03(String directoryPath) {
        this.directory = new File(directoryPath);
    }

    public void scan() {
        // Check if the directory exists
        if (!directory.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        // Check if the directory is a directory
        if (!directory.isDirectory()) {
            System.out.println("Provided path is not a directory!");
            return;
        }

        // Get all files in the directory
        File[] files = directory.listFiles();

        // Check if there are any files
        if (files == null) {
            System.out.println("Directory is empty!");
            return;
        }

        // Print the names and sizes of the files
        for (File file : files) {
            System.out.println("File: " + file.getName());
            System.out.println("Size: " + file.length() + " bytes");
            System.out.println("---------------------------");
        }
    }
}