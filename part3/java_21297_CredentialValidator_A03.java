import java.util.Base64;

public class java_21297_CredentialValidator_A03 {

    // This method is used to validate username and password
    public boolean validate(String username, String password) {
        // Decoding the username and password
        byte[] decodedUsername = Base64.getDecoder().decode(username);
        byte[] decodedPassword = Base64.getDecoder().decode(password);

        // Convert decoded bytes to String
        String decodedUsernameStr = new String(decodedUsername);
        String decodedPasswordStr = new String(decodedPassword);

        // Simulate a security-sensitive operation such as a login attempt
        if (decodedUsernameStr.equals("admin") && decodedPasswordStr.equals("password")) {
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Login failed!");
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Encode username and password before calling validate method
        String encodedUsername = Base64.getEncoder().encodeToString("admin".getBytes());
        String encodedPassword = Base64.getEncoder().encodeToString("password".getBytes());

        validator.validate(encodedUsername, encodedPassword);
    }
}