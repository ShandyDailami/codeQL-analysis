public class java_17145_CredentialValidator_A07 {
    private String correctUsername;
    private String correctPassword;

    public java_17145_CredentialValidator_A07(String correctUsername, String correctPassword) {
        this.correctUsername = correctUsername;
        this.correctPassword = correctPassword;
    }

    public boolean validate(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        if (username.equals(correctUsername) && password.equals(correctPassword)) {
            return true;
        } else {
            return false;
        }
    }
}

// Usage:
public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("admin", "password");

        System.out.println(validator.validate("admin", "password"));  // true
        System.out.println(validator.validate("wrongUser", "password"));  // false
        System.out.println(validator.validate("admin", "wrongPassword"));  // false
        System.out.println(validator.validate(null, "password"));  // false
        System.out.println(validator.validate("admin", null));  // false
        System.out.println(validator.validate(null, null));  // false
    }
}