import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_17121_FileScanner_A01 {

    public static void main(String[] args) {
        // Create a file scanner for the current file
        try {
            File file = new File("BrokenAccessControl.java");
            Scanner fileScanner = new Scanner(file);

            // Read file line by line
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);

                // Check for security-sensitive operations
                if (line.contains("access")) {
                    System.out.println("Access violation detected!");
                    break;
                }
            }
            fileScanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}