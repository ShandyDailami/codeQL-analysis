import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class java_11607_FileScanner_A03 {
    private static final SecurityManager securityManager = new SecurityManager() {
        @Override
        public boolean getSecurityAccess(String action) {
            // Only allow access if action is "read", which is the only operation
            // that we need to secure
            return action.equals("read");
        }
    };

    public static void main(String[] args) {
        // Use the custom SecurityManager for FileReader
        FileReader reader = new FileReader("your_file.txt", securityManager);

        try (Scanner scanner = new Scanner(reader)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}