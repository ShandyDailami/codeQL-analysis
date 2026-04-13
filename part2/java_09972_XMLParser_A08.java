import java.security.*;

public class java_09972_XMLParser_A08 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        // Creating a new secure random generator.
        SecureRandom sr = new SecureRandom();

        // Creating a 1024 bit (256 bytes) array with random bytes.
        byte[] randomBytes = new byte[1024];
        sr.nextBytes(randomBytes);

        // Updating the MessageDigest with the new random bytes.
        md.update(randomBytes);

        // Getting the hashed bytes from the MessageDigest.
        byte[] digest = md.digest();

        // Printing the hex representation of the hashed bytes.
        for(byte b : digest) {
            System.out.format("%02x", b);
        }
    }
}