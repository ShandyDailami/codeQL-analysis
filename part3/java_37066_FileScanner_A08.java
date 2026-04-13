import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class java_37066_FileScanner_A08 {
    private static final String SHA1 = "SHA-1";
    private static final String SHA256 = "SHA-256";
    private static final String MD5 = "MD5";
    private static final String DEFAULT_ALGORITHM = SHA1;

    private MessageDigest messageDigest;

    public java_37066_FileScanner_A08() {
        try {
            this.messageDigest = MessageDigest.getInstance(DEFAULT_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA algorithm not available. Your system is out-of-date.");
        }
    }

    public String hashFile(String filePath) {
        Path path = Paths.get(filePath);
        byte[] bytes = Files.readAllBytes(path);
        messageDigest.update(bytes);
        byte[] digest = messageDigest.digest();
        return bytesToHex(digest);
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            hexString.append(String.format("%02X", b));
        }
        return hexString.toString();
    }

    public boolean verifyFileIntegrity(String filePath, String expectedHash) {
        String actualHash = hashFile(filePath);
        return expectedHash.equals(actualHash);
    }

    public static void main(String[] args) {
        SecuritySensitiveFileScanner scanner = new SecuritySensitiveFileScanner();
        String expectedHash = scanner.hashFile("example.txt");
        System.out.println("Expected hash: " + expectedHash);

        boolean isVerified = scanner.verifyFileIntegrity("example.txt", expectedHash);
        System.out.println("File verified: " + isVerified);
    }
}