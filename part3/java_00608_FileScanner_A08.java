import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.AccessControlException;
import java.security.AccessDeniedException;
import java.security.Guard;
import java.security.Guardian;
import java.security.GuardianBroker;
import java.security.PrivilegedAction;
import java.util.Scanner;

public class java_00608_FileScanner_A08 {

    public static void main(String[] args) {
        File dir = new File("/path/to/your/directory");
        String extension = ".txt";
        File[] files = dir.listFiles((dir, name) -> name.endsWith(extension));
        Guardian guardian = new Guardian();
        try {
            for (File file : files) {
                guardian.doPrivileged(new FileReaderAction(file));
            }
        } catch (AccessControlException | AccessDeniedException e) {
            System.out.println("Access Denied: " + e.getMessage());
        }
    }

    static class FileReaderAction implements PrivilegedAction<FileReader> {
        private File file;

        public java_00608_FileScanner_A08(File file) {
            this.file = file;
        }

        public FileReader<AccessControl> doPrivileged(Guard g) throws AccessControlException {
            return new FileReader(file);
        }
    }
}