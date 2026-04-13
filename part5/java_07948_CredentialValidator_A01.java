public class java_07948_CredentialValidator_A01 {
    private String username;
    private String password;

    public java_07948_CredentialValidator_A01(String username, String password) {
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

public class CustomCredentialValidator {
    private static final String EXPECTED_USERNAME = "admin";
    private static final String EXPECTED_PASSWORD = "password";

    public boolean validate(Credential credential) {
        User user = new User(credential.getUsername(), credential.getPassword());

        return isUsernameValid(user.getUsername()) && isPasswordValid(user.getPassword());
    }

    private boolean isUsernameValid(String username) {
        return username.equals(EXPECTED_USERNAME);
    }

    private boolean isPasswordValid(String password) {
        return password.equals(EXPECTED_PASSWORD);
    }
}

public class Main {
    public static void main(String[] args) {
        Credential credential = new Credential("admin", "password");

        CustomCredentialValidator validator = new CustomCredentialValidator();
        boolean isValid = validator.validate(credential);

        if (isValid) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are invalid.");
        }
    }
}