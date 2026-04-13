import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_02234_FileScanner_A07 {
    public static void main(String[] args) {
        // Define the directory to start from
        File directory = new File("/path/to/directory");

        // Create a FileFilter that only accepts text files
        FileFilter filter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().toLowerCase().endsWith(".txt");
            }
        };

        // Use the listFiles method of File to get a list of all files in the directory
        File[] files = directory.listFiles(filter);

        // If there are no files, stop the program
        if (files == null) {
            System.out.println("No .txt files found in " + directory.getPath());
            return;
        }

        // Create a scanner to read the contents of each file
        for (File file : files) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    // Here you can process the line, for example, you can check if a line is a password
                    // And if it is, you can store it in a secure location, like a database,
                    // to prevent it from being exposed or stolen.
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + file.getPath());
            }
        }
    }
}