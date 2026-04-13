import java.io.File;
import java.util.Arrays;

public class java_28707_FileScanner_A01 {
    public static void main(String[] args) {
        // Get the list of files from a directory
        File directory = new File(".");
        File[] listOfFiles = directory.listFiles();

        // Check if there are any files in the directory
        if (listOfFiles == null) {
            System.out.println("No files in the current directory!");
            return;
        }

        // Print the list of files
        for (File file : listOfFiles) {
            System.out.println(file.getName());
        }
    }
}