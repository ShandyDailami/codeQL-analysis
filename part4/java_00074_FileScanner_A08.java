import java.io.*;
import java.security.*;

public class java_00074_FileScanner_A08 {
    private static final String DIRECTORY = "path/to/directory";

    public static void main(String[] args) {
        try {
            scanDirectory(DIRECTORY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void scanDirectory(String directory) throws Exception {
        File file = new File(directory);
        File[] files = file.listFiles();

        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    // Recursive call if file is a directory
                    scanDirectory(f.getAbsolutePath());
                } else {
                    // Process file
                    processFile(f);
                }
            }
        }
    }

    public static void processFile(File file) throws Exception {
        // Here you should implement a security-sensitive operation related to A08_IntegrityFailure
        // For example, checking file integrity
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        FileInputStream fis = new FileInputStream(file);

        byte[] buffer = new byte[1024];
        int length;
        while ((length = fis.read(buffer)) > 0) {
            md.update(buffer, 0, length);
        }

        byte[] digest = md.digest();

        // You can now compare the digest with the stored one or perform other security-sensitive operations
        // ...
    }
}