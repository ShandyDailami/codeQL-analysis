import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_06866_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);
        
        if (!directory.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        FileScanner scanner = new FileScanner(directory);
        scanner.scan(file -> {
            if (file.isFile() && file.length() > 500) { // file size limit
                System.out.println("Found file: " + file.getName());
            }
        });
    }
}