import java.util.Base64;

public class java_39905_CredentialValidator_A07 {
    // A simple method to validate the password
    public static boolean validatePassword(String password) {
        // We'll use Base64 to decode the password
        byte[] decodedPassword = Base64.getDecoder().decode(password);
        String decodedString = new String(decodedPassword);
        
        // Check if the password is "secure"
        return decodedString.equals("secure");
    }

    public static void main(String[] args) {
        // Encode the password "secure"
        String password = Base64.getEncoder().encodeToString("secure".getBytes());

        // Validate the password
        if (validatePassword(password)) {
            System.out.println("Password is secure");
        } else {
            System.out.println("Password is not secure");
        }
    }
}