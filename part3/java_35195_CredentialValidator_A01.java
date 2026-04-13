import java.security.InvalidParameterException;

public class java_35195_CredentialValidator_A01 {
    private String username;
    private String password;

    public java_35195_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
}

public class CredentialValidator {
    private User user;

    public java_35195_CredentialValidator_A01(User user) {
        this.user = user;
    }

    public boolean isValidCredential(String password) {
        return this.user.getPassword().equals(password);
    }
}