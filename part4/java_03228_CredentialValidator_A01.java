public interface CredentialValidator {
    boolean validate(String username, String password);
}

public class java_03228_CredentialValidator_A01 implements CredentialValidator {
    private static final String KNOWN_USERNAME = "admin";
    private static final String KNOWN_PASSWORD = "password";

    @Override
    public boolean validate(String username, String password) {
        return KNOWN_USERNAME.equals(username) && KNOWN_PASSWORD.equals(password);
    }
}

public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new LegacyCredentialValidator();
        String username = "admin";
        String password = "password";

        if (validator.validate(username, password)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}