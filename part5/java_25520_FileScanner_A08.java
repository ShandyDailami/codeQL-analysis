import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_25520_FileScanner_A08 {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        String knownHash = "A08_IntegrityFailure";
        String filePath = "/path/to/file";

        File file = new File(filePath);

        MessageDigest md = MessageDigest.getInstance("SHA-256");

        FileInputStream fis = new FileInputStream(file);

        byte[] buffer = new byte[1024];
        int read;

        while ((read = fis.read(buffer)) != -1) {
            md.update(buffer, 0, read);
        }

        byte[] digest = md.digest();

        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b));
        }

        String fileHash = sb.toString();

        if (fileHash.equals(knownHash)) {
            System.out.println("Integrity check successful.");
        } else {
            System.out.println("Integrity check failed.");
        }
    }
}