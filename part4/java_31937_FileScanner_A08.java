import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_31937_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        // Define the directory to scan
        File directory = new File("your/directory/path");

        // Use the listFiles method to get an array of all file entries in the directory
        File[] files = directory.listFiles();

        // Iterate over each file in the directory
        for (File file : files) {
            // Check if the file is a regular file (not a directory)
            if (file.isFile()) {
                // Use the Scanner class to read the contents of the file
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNext()) {
                        System.out.println(scanner.nextLine());
                    }
                }
            }
        }
    }
}