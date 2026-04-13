import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_04006_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        // Specify the directory and extension
        String directory = "/path/to/directory";
        String extension = ".txt";

        // Get all files in the directory and its subdirectories
        File[] files = new File(directory).listFiles();

        // Check each file
        for (File file : files) {
            // Check if the file is a text file
            if (file.isFile() && file.getName().endsWith(extension)) {
                // Use Scanner to read the file content
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        // Handle the line, for instance print it
                        System.out.println(line);
                    }
                }
            }
        }
    }
}