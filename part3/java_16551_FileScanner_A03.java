import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_16551_FileScanner_A03 {

    public static void main(String[] args) throws FileNotFoundException {
        // Specify the directory
        String directoryPath = "/path/to/directory";
        File directory = new File(directoryPath);

        // Get all files in the directory
        File[] files = directory.listFiles();

        // Print all files
        for (File file : files) {
            System.out.println(file.getName());
        }
    }
}