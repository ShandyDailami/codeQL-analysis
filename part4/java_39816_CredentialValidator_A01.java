import java.util.Base64;

public class java_39816_CredentialValidator_A01 {
    private String username;
    private String password;

    public java_39816_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean validate() {
        // In a real-world application, this would be a more complex validation
        // Here we're just checking if the username and password match a known good one
        String knownGoodUsername = "admin";
        String knownGoodPassword = "password";

        // Decode the Base64-encoded credentials
        String decodedUsername = new String(Base64.getDecoder().decode(username));
        String decodedPassword = new String(Base64.getDecoder().decode(password));

        // Check if the decoded credentials match the known good ones
        return decodedUsername.equals(knownGoodUsername) && decodedPassword.equals(knownGoodPassword);
    }
}