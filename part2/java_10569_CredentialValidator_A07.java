public class java_10569_CredentialValidator_A07 {
    private String username;
    private String password;

    public java_10569_CredentialValidator_A07(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean checkCredentials(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
}

public class CredentialValidator {
    private User user;

    public java_10569_CredentialValidator_A07(String username, String password) {
        user = new User(username, password);
    }

    public boolean validate(String username, String password) {
        return user.checkCredentials(username, password);
    }
}