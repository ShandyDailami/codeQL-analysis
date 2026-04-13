import javax.naming.AuthenticationException;

public interface CredentialValidator {
    boolean validate(String username, String password) throws AuthenticationException;
}

public class java_40825_CredentialValidator_A03 {
    private String username;
    private String password;

    public java_40825_CredentialValidator_A03(String username, String password) {
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

public class SecurityManager {
    private CredentialValidator validator;

    public java_40825_CredentialValidator_A03(CredentialValidator validator) {
        this.validator = validator;
    }

    public User login(String username, String password) throws AuthenticationException {
        if (validator.validate(username, password)) {
            return new User(username, password);
        } else {
            throw new AuthenticationException("Invalid username or password");
        }
    }
}

public class Main {
    public static void main(String[] args) throws AuthenticationException {
        CredentialValidator validator = new CredentialValidator() {
            @Override
            public boolean validate(String username, String password) {
                // This is a simple demonstration of Injection, not a real-world application
                // It could be replaced with a real authentication service
                return username.equals("admin") && password.equals("password");
            }
        };

        SecurityManager manager = new SecurityManager(validator);
        User user = manager.login("admin", "password");

        System.out.println("Logged in as user: " + user.getUsername());
    }
}