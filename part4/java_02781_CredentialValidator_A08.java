import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_02781_CredentialValidator_A08 {
    public static void main(String[] args) {
        String username = "user";
        String password = "password";
        String enteredPassword = "entered_password";

        // Create a hash of the password
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());

            // Convert the hash to a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            // Compare the hash with the entered password
            if(hexString.toString().equals(enteredPassword)) {
                System.out.println("Credentials are correct.");
            } else {
                System.out.println("Credentials are incorrect.");
            }

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}