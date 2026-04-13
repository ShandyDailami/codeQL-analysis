import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_41785_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        // 1. Create a new file object with a valid path
        File file = new File("src/main/java/BrokenAccessControl.java");

        // 2. Open a new scanner on the file
        Scanner scanner = new Scanner(file);

        // 3. Use a try-with-resources statement to automatically close the scanner when done
        try (scanner) {
            // 4. Read through the file line by line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Here we just print out the line, you can do something more meaningful with it
                System.out.println(line);
            }
        }
    }
}