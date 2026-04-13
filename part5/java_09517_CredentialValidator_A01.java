public class java_09517_CredentialValidator_A01 {
    private String username;
    private String password;

    public java_09517_CredentialValidator_A01(String username, String password) {
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
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    public boolean validate(User user) {
        return user.getPassword().matches(PASSWORD_PATTERN);
    }
}