public class java_09844_CredentialValidator_A03 {
    private String username;
    private String password;

    public java_09844_CredentialValidator_A03(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // getters and setters
}

public class Login {
    private User user;

    public java_09844_CredentialValidator_A03() {
        this.user = new User("admin", "password");
    }

    public boolean validate(String username, String password) {
        if (this.user.getUsername().equals(username) && this.user.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}

public class CredentialValidator {
    private Login login;

    public java_09844_CredentialValidator_A03() {
        this.login = new Login();
    }

    public boolean validateCredentials(String username, String password) {
        return this.login.validate(username, password);
    }
}

public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        if (validator.validateCredentials("admin", "password")) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are not valid.");
        }
    }
}