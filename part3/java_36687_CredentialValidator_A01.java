public interface CredentialValidator {
    boolean validate(String username, String password);
}

public class java_36687_CredentialValidator_A01 implements CredentialValidator {
    @Override
    public boolean validate(String username, String password) {
        // Here, we'll just check if the username contains 'admin'
        // This is not a secure way to validate credentials, but it's simple for the purpose of this example
        return !username.contains("admin");
    }
}

public class AdminValidator implements CredentialValidator {
    @Override
    public boolean validate(String username, String password) {
        // Here, we'll just check if the password is 'admin'
        // This is also not a secure way to validate credentials, but it's simple for the purpose of this example
        return password.equals("admin");
    }
}