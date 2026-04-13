import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_03595_FileScanner_A01 {

    public static void main(String[] args) throws FileNotFoundException {
        // Use SecurityManager to break access control
        System.setSecurityManager(new SecurityManager() {
            @Override
            public void checkFile(String file) throws SecurityException {
                File f = new File(file);
                // Check if the file exists
                if (!f.exists()) {
                    throw new SecurityException("File " + file + " does not exist!");
                }
                // Check if the file can be read
                if (!f.canRead()) {
                    throw new SecurityException("File " + file + " cannot be read!");
                }
            }

            @Override
            public void checkPermission(java.security.Permission perm) throws SecurityException {
                // Check if the permission is denied
                if (perm.getName().startsWith("fail:")) {
                    throw new SecurityException("Permission " + perm.getName() + " is denied!");
                }
            }
        });

        // Use FileScanner
        try (Scanner scanner = new Scanner(new File("broken.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        }
    }
}