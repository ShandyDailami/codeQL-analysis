public class java_02043_CredentialValidator_A08 {
    private String username;
    private String password;

    public java_02043_CredentialValidator_A08(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Method to check if password is strong enough
    public boolean isPasswordStrong() {
        return (password.length() >= 8 && password.matches(".*[0-9].*") && password.matches(".*[a-zA-Z].*") && password.matches(".*[^a-zA-Z0-9].*"));
    }

    // Method to check if password is weak enough
    public boolean isPasswordWeak() {
        return !isPasswordStrong();
    }
}

public interface CredentialValidator {
    boolean validate(User user);
}

public class BasicCredentialValidator implements CredentialValidator {
    public boolean validate(User user) {
        return user.getPassword().equals(user.getUsername());
    }
}

public class Main {
    public static void main(String[] args) {
        User user = new User("admin", "admin");
        CredentialValidator validator = new BasicCredentialValidator();

        if (validator.validate(user)) {
            System.out.println("Valid credentials!");
        } else {
            System.out.println("Invalid credentials!");
        }
    }
}