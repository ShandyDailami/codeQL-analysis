public class java_05071_CredentialValidator_A08 {
    private String username;
    private String password;

    public java_05071_CredentialValidator_A08(String username, String password) {
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
    private Credential[] credentials;

    public java_05071_CredentialValidator_A08(Credential[] credentials) {
        this.credentials = credentials;
    }

    public boolean isValid(String username, String password) {
        for (Credential credential : credentials) {
            if (credential.getUsername().equals(username) && credential.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}