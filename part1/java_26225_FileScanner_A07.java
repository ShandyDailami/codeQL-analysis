import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.security.Permission;
import java.security.SecurityManager;

public class java_26225_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String dirPath = scanner.nextLine();

        // Create a new SecurityManager
        SecurityManager sm = new SecurityManager() {
            @Override
            public boolean checkDelete(String file) throws SecurityException {
                // Only allow deletion of files in the specified directory
                return file.startsWith(dirPath);
            }

            @Override
            public boolean checkRead(String file) throws SecurityException {
                // Only allow reading of files in the specified directory
                return file.startsWith(dirPath);
            }

            @Override
            public boolean checkWrite(String file) throws SecurityException {
                // Only allow writing to files in the specified directory
                return file.startsWith(dirPath);
            }

            @Override
            public void checkAccess(AccessControl action) throws SecurityException {
                // Check if the action is allowed
                if (!action.isPermitted(file)) {
                    throw new SecurityException("Access denied");
                }
            }

            @Override
            public void checkFile(String file) throws SecurityException {
                // Check if the file exists
                if (!new File(file).exists()) {
                    throw new SecurityException("File does not exist");
                }
            }
        };

        // Set the security manager
        System.setSecurityManager(sm);

        try {
            // Open the file
            FileReader reader = new FileReader("test.txt");
            // No need to remove the comment because it is syntactically correct
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        }
    }
}