import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_31441_FileScanner_A01 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("src/main/resources/accessControl.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Process the line here
                // If the line contains 'brokenAccess', print a warning message
                if (line.contains("brokenAccess")) {
                    System.out.println("Warning: Access to file/resource is being restricted due to broken access control.");
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}