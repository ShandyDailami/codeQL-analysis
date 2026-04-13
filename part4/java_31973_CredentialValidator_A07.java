import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class java_31973_CredentialValidator_A07 {
    private String username;
    private String password;

    public java_31973_CredentialValidator_A07(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean validate() {
        // In a real-world application, you would likely have a database of known users and password hashes.
        // For simplicity, this example uses a dummy hash.
        String expectedPassword = getSHA256Hash("password", "salt");

        return username.equals("user") && password.equals(expectedPassword);
    }

    private static String getSHA256Hash(String input, String salt) {
        String saltedInput = salt + input;
        MessageDigest digest;
        byte[] hash;

        try {
            digest = MessageDigest.getInstance("SHA-256");
            hash = digest.digest(saltedInput.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return Base64.getEncoder().encodeToString(hash);
    }

    public static void main(String[] args) {
        String username = "user";
        String password = getSHA256Hash("password", "salt");

        CredentialValidator validator = new CredentialValidator(username, password);

        if (validator.validate()) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}