import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.AccessControl;
import java.security.AccessController;

public class java_08871_FileScanner_A08 {
    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        scanner.scanFiles(".", ".");
    }
}

class FileScanner {
    private AccessControl context = AccessController.getContext();
    private PermissionCollection perms = context.getPermissions();

    public void scanFiles(String directory, String pattern) {
        File dir = new File(directory);
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanFiles(file.getPath(), pattern);
                } else if (file.getName().matches(pattern)) {
                    try {
                        scanFile(file);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    private void scanFile(File file) throws FileNotFoundException {
        if (perms.denies(new SecurityPermission.UnixFilePermission(file.getPath()))) {
            throw new FileNotFoundException("Unable to read file: " + file.getPath());
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Here you can implement your own security operations related to A08_IntegrityFailure
            }
        }
    }
}