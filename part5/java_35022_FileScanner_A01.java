import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.security.AccessControlException;
import java.security.AccessDeniedException;
import java.security.PrivilegedAction;

public class java_35022_FileScanner_A01 {

    public static void main(String[] args) {
        File file = new File(".");
        scanFile(file);
    }

    public static void scanFile(File file) {
        try {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                if (files != null) {
                    for (File f : files) {
                        scanFile(f);
                    }
                }
            } else {
                checkFileAccess(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void checkFileAccess(File file) throws IOException {
        PrivilegedAction<?> action = new PrivilegedAction<Void>() {
            public Void run() {
                try {
                    Files.readAttributes(Paths.get(file.getPath()), BasicFileAttributes.class);
                    System.out.println("Access granted to " + file.getPath());
                    return null;
                } catch (AccessDeniedException e) {
                    System.out.println("Access denied to " + file.getPath());
                    return null;
                }
            }
        };
        try {
            action.run();
        } catch (AccessControlException e) {
            System.out.println("Access control error while accessing " + file.getPath());
        }
    }
}