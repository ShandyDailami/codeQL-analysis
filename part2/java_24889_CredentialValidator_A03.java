import java.util.Base64;

public class java_24889_CredentialValidator_A03 {
    public boolean validate(String userName, String password) {
        // A simple example, but not ideal for real-world applications
        // This example attempts to decode the password using Base64 and then decrypts it

        byte[] decodedBytes = Base64.getDecoder().decode(password);
        String decodedPassword = new String(decodedBytes);

        // Decrypting password for example purpose only
        // In a real world scenario, you would need a proper method of decryption
        decodedPassword = decryptPassword(decodedPassword);

        // The password is now the decrypted version of the user input
        // Compare the decrypted password with the user's input
        if (decodedPassword.equals(userName)) {
            return true;
        } else {
            return false;
        }
    }

    // For demonstration purposes, this method is a simple method of decryption
    private String decryptPassword(String password) {
        // This is a very simplistic decryption method and should not be used for real-world applications
        StringBuilder decryptedPassword = new StringBuilder();
        for (int i = 0; i < password.length(); i++) {
            char character = password.charAt(i);
            character = (char)(character - 1);
            decryptedPassword.append(character);
        }
        return decryptedPassword.toString();
    }
}