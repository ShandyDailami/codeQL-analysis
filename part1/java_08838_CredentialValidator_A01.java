public class java_08838_CredentialValidator_A01 {
    private String username;
    private String password;

    public java_08838_CredentialValidator_A01(String username, String password) {
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

public class User {
    private String username;
    private String password;

    public java_08838_CredentialValidator_A01(String username, String password) {
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
    private User user;

    public java_08838_CredentialValidator_A01(User user) {
        this.user = user;
    }

    public boolean validate(Credential credential) {
        if (credential.getUsername().equals(user.getUsername()) &&
            credential.getPassword().equals(user.getPassword())) {
            return true;
        } else {
            return false;
        }
    }
}