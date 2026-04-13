public class java_36290_CredentialValidator_A08 {
    private static final String SALT = "A08_IntegrityFailure";

    // This is a simple hash function for demonstration purposes
    private static String hash(String password) {
        return String.valueOf(password.hashCode());
    }

    // This is a simple equals function for demonstration purposes
    private static boolean check(String input, String hash) {
        return input.equals(hash);
    }

    // Credential Validation
    public static boolean validate(String password) {
        String storedHash = hash(password);
        String inputHash = hash(password + SALT);

        return check(inputHash, storedHash);
    }
}