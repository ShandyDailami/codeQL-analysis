import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class java_36141_FileScanner_A01 {

    // This method uses a privileged action to scan a directory for files.
    // This is a security-sensitive operation.
    public static void scanDirectory(String directoryPath) {
        AccessController.doPrivileged(new PrivilegedAction<Void>() {
            public Void run() {
                File directory = new File(directoryPath);
                File[] files = directory.listFiles();
                if (files != null) {
                    for (File file : files) {
                        if (file.isFile()) {
                            try {
                                FileReader reader = new FileReader(file);
                                Scanner scanner = new Scanner(reader);
                                while (scanner.hasNextLine()) {
                                    System.out.println(scanner.nextLine());
                                }
                                scanner.close();
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                        } else if (file.isDirectory()) {
                            scanDirectory(file.getPath());
                        }
                    }
                }
                return null;
            }
        });
    }

    public static void main(String[] args) {
        scanDirectory("/path/to/directory");  // replace with your directory path
    }
}