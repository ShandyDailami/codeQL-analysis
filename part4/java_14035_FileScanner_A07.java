import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.AccessControlException;
import java.security.SecurityPermission;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_14035_FileScanner_A07 {

    private static class SecurityManager extends java.security.SecurityManager {
        public void checkPermission(java.security.Permission perm) throws AccessControlException {
            if (perm instanceof SecurityPermission) {
                throw new AccessControlException("Permission " + perm + " refused");
            }
        }
    }

    public static void main(String[] args) {
        // Create a SecurityManager
        SecurityManager sm = new SecurityManager();
        // Set the SecurityManager for the current thread
        Thread.currentThread().setSecurityManager(sm);

        String directory = "/path/to/directory";
        String pattern = "pattern";

        List<File> files = new ArrayList<>();

        try (Scanner scanner = new Scanner(new FileReader(new File(directory)))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.matches(pattern)) {
                    File file = new File(directory, line);
                    if (file.exists() && file.isFile()) {
                        files.add(file);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Directory not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading directory: " + e.getMessage());
        }

        // Print files
        for (File file : files) {
            System.out.println(file.getPath());
        }
    }
}