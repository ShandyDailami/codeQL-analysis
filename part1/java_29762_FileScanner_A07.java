import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_29762_FileScanner_A07 {
    public static void main(String[] args) {
        // Unique Vanilla Java FileScanner Example

        // A simple program to read files from a directory

        try {
            File file = new File("path_to_your_directory");
            Scanner scanner = new Scanner(file);

            // Read each line of the file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }

    }
}