public interface CredentialValidator {
    boolean validate(String username, String password);
}

public class java_33527_CredentialValidator_A01 implements CredentialValidator {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    @Override
    public boolean validate(String username, String password) {
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }
}