import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_03149_FileScanner_A07 {
    public static void main(String[] args) {
        // Create a File object for the target directory
        File targetDirectory = new File("C:\\Users\\your_user\\your_directory");

        // Get all files in the target directory
        File[] files = targetDirectory.listFiles();

        // Iterate over the files
        for (File file : files) {
            if (file.isFile()) {
                // If the file is a text file, read the file content
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        // Perform security-sensitive operations here
                        // For example, check for a specific keyword in the line
                        if (line.contains("your_keyword")) {
                            System.out.println("Found suspicious line: " + line);
                        }
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}