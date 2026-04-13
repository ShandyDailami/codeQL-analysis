public class java_30103_CredentialValidator_A08 {
    private String username;
    private String password;

    public java_30103_CredentialValidator_A08(String username, String password) {
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

    public java_30103_CredentialValidator_A08(User user) {
        this.user = user;
    }

    public boolean validateCredentials(String username, String password) {
        if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
            return true;
        } else {
            return false;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        User user = new User("admin", "password");
        CredentialValidator credentialValidator = new CredentialValidator(user);

        if (credentialValidator.validateCredentials("admin", "password")) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}