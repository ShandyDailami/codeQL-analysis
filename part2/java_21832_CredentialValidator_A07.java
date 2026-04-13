import java.security.InvalidParameterException;
import java.util.Base64;

public class java_21832_CredentialValidator_A07 {
    // This is a placeholder for actual credential validation
    public boolean validate(String user, String password) {
        // Decoding the credentials from base64
        byte[] decodedPassword = Base64.getDecoder().decode(password);
        String decodedUser = new String(decodedPassword, "UTF-8");

        // Validation logic here (for example, checking if user and password match a known good user/password)
        if (decodedUser.equals("admin") && decodedPassword.equals("secret")) {
            return true;
        } else {
            return false;
        }
    }

    // This is the main method where the validation happens
    public static void main(String[] args) {
        String user = "YOUR_USER";
        String password = "YOUR_PASSWORD";

        // Validate the user's credentials
        try {
            LegacyCredentialValidator validator = new LegacyCredentialValidator();
            boolean isValid = validator.validate(user, password);
            if (isValid) {
                System.out.println("Access granted!");
            } else {
                System.out.println("Access denied!");
            }
        } catch (InvalidParameterException e) {
            System.out.println("Invalid parameter!");
        }
    }
}