public class java_11859_CredentialValidator_A01 {
    private String password;

    public java_11859_CredentialValidator_A01(String password) {
        this.password = password;
    }

    public boolean isPasswordCorrect(String providedPassword) {
        return this.password.equals(providedPassword);
    }
}

public class User {
    private Credentials credentials;

    public java_11859_CredentialValidator_A01(String password) {
        this.credentials = new Credentials(password);
    }

    public boolean hasAccess(Credentials providedCredentials) {
        return this.credentials.isPasswordCorrect(providedCredentials.getPassword());
    }
}

public class CredentialValidator {
    public boolean validate(User user, Credentials credentials) {
        return user.hasAccess(credentials);
    }
}