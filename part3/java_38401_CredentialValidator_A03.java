import java.util.Base64;

public class java_38401_CredentialValidator_A03 {

    public boolean validateCredential(String user, String password) {
        // Replace this with a real function to validate the user's credentials.
        // For simplicity, this example just checks if the password is the same as the user name.
        return password.equals(user);
    }

    public String encryptCredential(String user, String password) {
        // Encrypt the password using Base64.
        // This is a simple way to mask the password. For real-world applications, use secure methods.
        return Base64.getEncoder().encodeToString((user + ":" + password).getBytes());
    }

    public String decryptCredential(String encryptedCredential) {
        // Decrypt the encrypted credential using Base64.
        // This is a simple way to decrypt the password. For real-world applications, use secure methods.
        byte[] decodedBytes = Base64.getDecoder().decode(encryptedCredential);
        return new String(decodedBytes);
    }

    public static void main(String[] args) {
        CustomCredentialValidator validator = new CustomCredentialValidator();

        // Test the validator.
        String user = "test";
        String password = "test";
        String encryptedCredential = validator.encryptCredential(user, password);
        System.out.println("Encrypted credential: " + encryptedCredential);

        String decryptedCredential = validator.decryptCredential(encryptedCredential);
        System.out.println("Decrypted credential: " + decryptedCredential);

        boolean isValid = validator.validateCredential(user, decryptedCredential);
        System.out.println("Is valid: " + isValid);
    }
}