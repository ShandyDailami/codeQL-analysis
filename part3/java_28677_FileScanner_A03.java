import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_28677_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    Scanner fileScanner = new Scanner(file);
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        // perform security-sensitive operation, e.g., injecting SQL query
                        // you may use any libraries or frameworks to perform operations
                        // e.g., Hibernate or Spring
                    }
                    fileScanner.close();
                }
            }
        }
    }
}