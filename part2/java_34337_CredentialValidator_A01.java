public class java_34337_CredentialValidator_A01 {
    private String correctUsername;
    private String correctPassword;

    public java_34337_CredentialValidator_A01(String correctUsername, String correctPassword) {
        this.correctUsername = correctUsername;
        this.correctPassword = correctPassword;
    }

    public boolean validate(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        if (username.equals(correctUsername) && password.equals(correctPassword)) {
            return true;
        }

        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("admin", "password");

        boolean isValid = validator.validate("admin", "password");
        System.out.println("Is valid: " + isValid);

        isValid = validator.validate("wrong_username", "password");
        System.out.println("Is valid: " + isValid);

        isValid = validator.validate("admin", "wrong_password");
        System.out.println("Is valid: " + isValid);
    }
}