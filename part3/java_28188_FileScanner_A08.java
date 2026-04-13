import java.io.*;
import java.nio.file.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_28188_FileScanner_A08 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String filePath = "/path/to/file";  // Replace with your file path
        String expectedHash = "expected_hash";  // Replace with your expected hash

        MessageDigest md = MessageDigest.getInstance("SHA-256");

        try (InputStream is = new FileInputStream(filePath)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) != -1) {
                md.update(buffer, 0, length);
            }
            byte[] digest = md.digest();

            StringBuilder hash = new StringBuilder();
            for (byte b : digest) {
                hash.append(String.format("%02x", b));
            }

            if (!hash.toString().equals(expectedHash)) {
                System.out.println("Integrity check failed!");
            } else {
                System.out.println("Integrity check passed!");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("IO error occurred!");
        }
    }
}