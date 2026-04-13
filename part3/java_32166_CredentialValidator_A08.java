public class java_32166_CredentialValidator_A08 {
    private String username;
    private String password;

    public java_32166_CredentialValidator_A08(String username, String password) {
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
    private UserCredential validUser;

    public java_32166_CredentialValidator_A08() {
        validUser = new UserCredential("admin", "password");
    }

    public boolean validate(String username, String password) {
        if (username.equals(validUser.getUsername()) && password.equals(validUser.getPassword())) {
            return true;
        } else {
            return false;
        }
    }
}