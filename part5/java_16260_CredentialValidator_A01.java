public class java_16260_CredentialValidator_A01 {
    private String username;
    private String password;

    public java_16260_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean validate(String enteredUsername, String enteredPassword) {
        return this.username.equals(enteredUsername) && this.password.equals(enteredPassword);
    }
}

public class CredentialValidator {
    private Credential credential;

    public java_16260_CredentialValidator_A01(String username, String password) {
        this.credential = new Credential(username, password);
    }

    public boolean validate(String enteredUsername, String enteredPassword) {
        return this.credential.validate(enteredUsername, enteredPassword);
    }
}

public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("admin", "password");
        boolean isValid = validator.validate("admin", "password");
        System.out.println("Is valid: " + isValid);
    }
}