import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_12653_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        // Get the current directory path
        String dirPath = System.getProperty("user.dir") + File.separator;

        // Create a new file scanner for the current directory
        File directory = new File(dirPath);
        File[] listOfFiles = directory.listFiles();

        // Check if the directory is empty
        if (listOfFiles == null || listOfFiles.length == 0) {
            System.out.println("No files found in the directory!");
            return;
        }

        // Print all the files in the directory
        System.out.println("Files in the directory:");
        for (File file : listOfFiles) {
            System.out.println(file.getName());
        }
    }
}