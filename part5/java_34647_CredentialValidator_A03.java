public class java_34647_CredentialValidator_A03 {
    private String username;
    private String password;

    public java_34647_CredentialValidator_A03(String username, String password) {
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
    private Credential storedCredential;

    public java_34647_CredentialValidator_A03() {
        storedCredential = new Credential("admin", "password"); // This is a placeholder. Real use-case would store credentials in a secure way.
    }

    public boolean validate(String username, String password) {
        if (username.equals(storedCredential.getUsername()) && password.equals(storedCredential.getPassword())) {
            return true;
        } else {
            return false;
        }
    }
}