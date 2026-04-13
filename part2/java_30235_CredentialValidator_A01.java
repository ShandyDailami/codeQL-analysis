public class java_30235_CredentialValidator_A01 {
    private String username;
    private String password;

    public java_30235_CredentialValidator_A01(String username, String password) {
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
    private Credential existingCredential;

    public java_30235_CredentialValidator_A01(Credential existingCredential) {
        this.existingCredential = existingCredential;
    }

    public boolean isValid(String enteredPassword) {
        return enteredPassword.equals(this.existingCredential.getPassword());
    }
}