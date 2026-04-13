import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_23095_FileScanner_A01 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("src/main/resources/access.control"));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);

                // This is a security-sensitive operation related to A01_BrokenAccessControl
                // For example, checking if the file exists, reading the file, or writing to the file.
                if (line.contains("access.control")) {
                    System.out.println("Access to the file is restricted!");
                    break;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}