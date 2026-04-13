import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_05450_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        // Get the directory path
        String directoryPath = new File(".").getAbsolutePath();

        // Get all files in the directory
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        // Check if there are files
        if (files != null) {
            for (File file : files) {
                // Check if file is not directory
                if (file.isFile()) {
                    // Create a scanner for the file
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line);
                    }
                    scanner.close();
                }
            }
        }
    }
}