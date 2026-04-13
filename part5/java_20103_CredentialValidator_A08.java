public class java_20103_CredentialValidator_A08 {

    // This is a hard-coded password.
    private static final String EXPECTED_PASSWORD = "expectedPassword";

    public boolean validate(String password) {
        // If the password is null or it's not equal to the expected password, return false.
        if (password == null || !password.equals(EXPECTED_PASSWORD)) {
            return false;
        }
        // If the password is equal to the expected password, return true.
        return true;
    }
}