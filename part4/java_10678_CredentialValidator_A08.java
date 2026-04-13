public class java_10678_CredentialValidator_A08 {
    private String username;
    private String password;

    public java_10678_CredentialValidator_A08(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

public class CredentialValidator {
    private Credential expectedCredential;

    public java_10678_CredentialValidator_A08(String expectedUsername, String expectedPassword) {
        this.expectedCredential = new Credential(expectedUsername, expectedPassword);
    }

    public boolean isValidCredential(String username, String password) {
        if (username.equals(expectedCredential.getUsername()) && password.equals(expectedCredential.getPassword())) {
            return true;
        } else {
            return false;
        }
    }
}