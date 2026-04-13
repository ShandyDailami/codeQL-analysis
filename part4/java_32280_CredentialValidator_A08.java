public class java_32280_CredentialValidator_A08 {
    private String username;
    private String password;

    public java_32280_CredentialValidator_A08(String username, String password) {
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
    public boolean validate(User user) {
        String password = user.getPassword();
        return password.matches("^.{8,}$");
    }
}