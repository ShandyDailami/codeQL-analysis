import java.util.Base64;

public class java_04662_CredentialValidator_A08 {
    private String password;

    public java_04662_CredentialValidator_A08(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}

public class CredentialValidator {
    // Assuming CredentialValidator is a Service class
    public boolean validateCredentials(Credential credential) {
        String encodedPassword = credential.getPassword();
        String expectedPassword = "encodedPassword"; // Replace this with the expected password

        // Decode the password
        byte[] decodedBytes = Base64.getDecoder().decode(encodedPassword);
        String decodedPassword = new String(decodedBytes);

        // Compare the decoded password with the expected password
        if (decodedPassword.equals(expectedPassword)) {
            return true;
        } else {
            return false;
        }
    }
}