import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class java_34321_CredentialValidator_A01 {

    // Private fields
    private String username;
    private String password;

    // Constructor
    public java_34321_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Method to validate the credentials
    public boolean validateCredentials(String encodedUsername, String encodedPassword) {
        Decoder decoder = Base64.getDecoder();

        try {
            String decodedUsername = new String(decoder.decode(encodedUsername));
            String decodedPassword = new String(decoder.decode(encodedPassword));

            return decodedUsername.equals(this.username) && decodedPassword.equals(this.password);
        } catch (Exception e) {
            return false;
        }
    }
}