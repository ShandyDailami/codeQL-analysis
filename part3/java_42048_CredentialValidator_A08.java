import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_42048_CredentialValidator_A08 {
    private static final String HASH_ALGORITHM = "SHA-256";

    private File hashFile;

    public java_42048_CredentialValidator_A08(String hashFilePath) {
        this.hashFile = new File(hashFilePath);
    }

    public boolean isPasswordValid(String passwordAttempt) throws IOException, NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);
        digest.update(passwordAttempt.getBytes());
        byte[] hash = digest.digest();

        // Read the stored hash from the file
        byte[] storedHash = Files.readAllBytes(hashFile.toPath());

        // Compare the stored and calculated hashes
        if (hash.length != storedHash.length) {
            throw new NoSuchAlgorithmException("Hash length does not match");
        }

        int difference = compareByteArrays(hash, storedHash);
        return difference < 0;
    }

    private static int compareByteArrays(byte[] a, byte[] b) {
        int len = a.length;
        if (b.length > len) {
            len = b.length;
        }

        int result = 0;
        for (int i = 0; i < len; i++) {
            result |= a[i] ^ b[i];
        }
        return result;
    }
}