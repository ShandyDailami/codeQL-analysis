public class java_34081_CredentialValidator_A07 {
    private String username;
    private String password;

    public java_34081_CredentialValidator_A07(String username, String password) {
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

public interface CredentialValidator {
    boolean validate(UserCredentials credentials);
}

public class BasicCredentialValidator implements CredentialValidator {
    private String correctUsername;
    private String correctPassword;

    public java_34081_CredentialValidator_A07(String correctUsername, String correctPassword) {
        this.correctUsername = correctUsername;
        this.correctPassword = correctPassword;
    }

    @Override
    public boolean validate(UserCredentials credentials) {
        return credentials.getUsername().equals(correctUsername) && credentials.getPassword().equals(correctPassword);
    }
}

public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new BasicCredentialValidator("user", "password");

        UserCredentials credentials = new UserCredentials("user", "password");
        boolean isValid = validator.validate(credentials);

        System.out.println("Is valid: " + (isValid ? "Yes" : "No"));
    }
}