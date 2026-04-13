public class java_01326_CredentialValidator_A03 {
    private String username;
    private String password;

    public java_01326_CredentialValidator_A03(String username, String password) {
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

public class Credential {
    private String username;
    private String password;

    public java_01326_CredentialValidator_A03(String username, String password) {
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

public class PasswordValidator {
    public boolean validate(User user, Credential credential) {
        if (user.getUsername().equals(credential.getUsername()) &&
            user.getPassword().equals(credential.getPassword())) {
            return true;
        } else {
            return false;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        User user = new User("user1", "password");
        Credential credential = new Credential("user1", "password");

        PasswordValidator validator = new PasswordValidator();

        boolean isValid = validator.validate(user, credential);

        System.out.println("Is valid: " + isValid);
    }
}