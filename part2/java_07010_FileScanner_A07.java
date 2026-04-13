import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_07010_FileScanner_A07 {

    public static void main(String[] args) throws FileNotFoundException {
        // Set up the directory to scan
        File directory = new File("path_to_your_directory");

        // Use a FileFilter to only look for files with .txt extensions
        File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

        // If no .txt files are found, exit the program
        if (txtFiles == null) {
            System.out.println("No .txt files found in the directory.");
            System.exit(1);
        }

        // Scan each .txt file
        for (File txtFile : txtFiles) {
            Scanner scanner = new Scanner(txtFile);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // Check for specific words in the line and print them out
                if (line.contains("sensitive_word1") || line.contains("sensitive_word2")) {
                    System.out.println("Line contains sensitive words: " + line);
                }
            }
            scanner.close();
        }
    }
}