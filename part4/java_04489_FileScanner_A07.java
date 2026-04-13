import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Logger;

public class java_04489_FileScanner_A07 {

    private static final Logger logger = Logger.getLogger(SecureFileScanner.class.getName());

    private SecurityManager securityManager;

    public java_04489_FileScanner_A07() {
        securityManager = System.getSecurityManager();
        if (securityManager == null) {
            throw new SecurityException("No security manager found");
        }
    }

    public void startScanning(String directory) throws SecurityException {
        if (securityManager.checkFilePermission(directory, File.readLink(directory))) {
            File file = new File(directory);
            if (file.isDirectory()) {
                String[] files = file.list();
                for (String name : files) {
                    startScanning(file.getPath() + "/" + name);
                }
            } else {
                try {
                    printFileContent(file);
                } catch (FileNotFoundException e) {
                    logger.warning("FileNotFoundException: " + file.getPath());
                }
            }
        } else {
            throw new SecurityException("Permission Denied: " + directory);
        }
    }

    private void printFileContent(File file) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                logger.info(scanner.nextLine());
            }
        }
    }

    public static void main(String[] args) {
        SecureFileScanner scanner = new SecureFileScanner();
        scanner.startScanning(".");
    }
}