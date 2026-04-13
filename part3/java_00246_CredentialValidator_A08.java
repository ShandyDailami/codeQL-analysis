public class java_00246_CredentialValidator_A08 {
    private String username;
    private String password;

    public java_00246_CredentialValidator_A08(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

public class CredentialValidator {
    private Credential[] credentials;

    public java_00246_CredentialValidator_A08(Credential[] credentials) {
        this.credentials = credentials;
    }

    public boolean isValidPassword(String username, String password) {
        for (Credential credential : credentials) {
            if (credential.getUsername().equals(username) && credential.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public boolean isValidUsername(String username) {
        for (Credential credential : credentials) {
            if (credential.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
}