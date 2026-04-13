public class java_08769_CredentialValidator_A03 {
    private String username;
    private String password;

    public java_08769_CredentialValidator_A03(String username, String password) {
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
    private String enteredPassword;

    public java_08769_CredentialValidator_A03(String enteredPassword) {
        this.enteredPassword = enteredPassword;
    }

    public String getEnteredPassword() {
        return enteredPassword;
    }
}

public class CredentialValidator {
    public boolean validate(User user, Credential credential) {
        return user.getPassword().equals(credential.getEnteredPassword());
    }
}

public class Main {
    public static void main(String[] args) {
        User user = new User("admin", "password");
        Credential credential = new Credential("password");

        CredentialValidator validator = new CredentialValidator();
        boolean isValid = validator.validate(user, credential);

        if (isValid) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are invalid.");
        }
    }
}