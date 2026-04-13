import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_09230_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        // Define the starting directory
        String startDir = "/path/to/directory";

        // Start the scanner
        File startFile = new File(startDir);
        Scanner fileScanner = new Scanner(startFile);

        // List all files in the directory
        while (fileScanner.hasNext()) {
            String fileName = fileScanner.next();
            File file = new File(fileName);
            if (file.isFile()) {
                System.out.println("File: " + file.getName());
            } else if (file.isDirectory()) {
                System.out.println("Directory: " + file.getName());
            }
        }

        // Close the scanner
        fileScanner.close();
    }
}