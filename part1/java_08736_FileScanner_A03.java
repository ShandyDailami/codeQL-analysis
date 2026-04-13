import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_08736_FileScanner_A03 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("test.txt"));  // 1. Use standard Java FileScanner
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // 2. Use standard Java FileScanner, but be careful with this operation
                // This operation is vulnerable to injection attacks if the input string is not properly sanitized
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}