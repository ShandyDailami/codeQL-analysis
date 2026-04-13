public class java_37924_CredentialValidator_A01 {
    private String username;
    private String password;

    public java_37924_CredentialValidator_A01(String username, String password) {
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

public interface CredentialValidator {
    boolean validate(String username, String password);
}

public class DefaultCredentialValidator implements CredentialValidator {
    private User user;

    public java_37924_CredentialValidator_A01(String username, String password) {
        user = new User(username, password);
    }

    @Override
    public boolean validate(String username, String password) {
        return user.getUsername().equals(username) && user.getPassword().equals(password);
    }
}