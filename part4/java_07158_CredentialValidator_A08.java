import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class java_07158_CredentialValidator_A08 {

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Generate a random password
        String password = validator.generatePassword();

        // Compare the user's input password to the generated password
        if (validator.comparePassword("test", password)) {
            System.out.println("Login successful");
        } else {
            System.out.println("Login failed");
        }
    }
}

class CredentialValidator {

    private static final SecureRandom random = new SecureRandom();

    public String generatePassword() {
        byte bytes[] = new byte[16];
        random.nextBytes(bytes);
        String generatedPassword = Base64.getEncoder().encodeToString(bytes);
        return generatedPassword;
    }

    public boolean comparePassword(String userInput, String generatedPassword) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(userInput.getBytes());
            byte[] hashedPassword = md.digest();
            return compareByteArrays(generatedPassword.getBytes(), hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean compareByteArrays(byte[] a, byte[] b) {
        if (a.length != b.length)
            return false;
        for (int i = 0; i < a.length; i++)
            if (a[i] != b[i])
                return false;
        return true;
    }
}