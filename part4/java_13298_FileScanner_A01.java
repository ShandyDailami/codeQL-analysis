import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_13298_FileScanner_A01 {
    public static void main(String[] args) {
        try {
            File file = new File("path/to/your/file"); // replace with your file path
            Scanner scanner = new Scanner(file);

            // Check if the file is readable
            if (!file.canRead()) {
                throw new SecurityException("File is not readable. Access denied.");
            }

            // Check if the file is writeable
            if (!file.setWritable(true)) {
                throw new SecurityException("File is not writeable. Access denied.");
            }

            // Read the file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        }
    }
}