import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.AccessControlException;
import java.security.Permission;
import java.security.SecurityManager;
import java.security.PrivilegedAction;

public class java_06007_FileScanner_A07 {
    private SecurityManager securityManager;

    public java_06007_FileScanner_A07(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    public void scan(String directoryPath) {
        File directory = new File(directoryPath);

        securityManager.doPrivileged(new PrivilegedAction<Void>() {
            @Override
            public Void run() {
                File[] files = directory.listFiles();
                for (File file : files) {
                    if (file.isDirectory()) {
                        scan(file.getPath());
                    } else {
                        readFile(file.getPath());
                    }
                }
                return null;
            }
        });
    }

    private void readFile(String filePath) {
        try {
            FileReader reader = new FileReader(filePath);
            // Read file here. You can remove this part if you don't need to read the file.
            // reader.read();
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SecurityManager securityManager = new SecurityManager();
        VanillaFileScanner scanner = new VanillaFileScanner(securityManager);
        scanner.scan("/path/to/directory");
    }
}