import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class java_41619_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File("path_to_your_file.txt");
        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getPath());
            return;
        }

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            // Handle line as required. For example, print to console:
            System.out.println(line);
        }

        scanner.close();

        // Handling no element exception as there might be an issue with file access or the file doesn't exist.
        } catch (NoSuchElementException e) {
            System.out.println("Error reading file: " + file.getPath());
        }
    }
}