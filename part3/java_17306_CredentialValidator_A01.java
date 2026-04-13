public class java_17306_CredentialValidator_A01 {

    // In real application, the real credentials should be encrypted and stored in a secure way.
    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password";

    public boolean validate(String username, String password) {
        // In a real application, the real credentials should also be encrypted and compared with the encrypted versions.
        return username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD);
    }
}