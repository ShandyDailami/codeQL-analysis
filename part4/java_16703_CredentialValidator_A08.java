public class java_16703_CredentialValidator_A08 {
    private String username;
    private String password;

    public java_16703_CredentialValidator_A08(String username, String password) {
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

    public java_16703_CredentialValidator_A08(User user) {
        this.user = user;
    }

    public boolean validateCredentials(String inputUsername, String inputPassword) {
        return inputUsername.equals(user.getUsername()) && inputPassword.equals(user.getPassword());
    }
}

public class Main {
    public static void main(String[] args) {
        User user = new User("admin", "password");
        CredentialValidator validator = new CredentialValidator(user);

        System.out.println(validator.validateCredentials("admin", "password"));
        System.out.println(validator.validateCredentials("wrongusername", "password"));
        System.out.println(validator.validateCredentials("admin", "wrongpassword"));
    }
}