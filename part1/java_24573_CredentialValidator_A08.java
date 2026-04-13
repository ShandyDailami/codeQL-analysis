public class java_24573_CredentialValidator_A08 {

    private static final int MAX_FAILURE_ATTEMPTS = 3;
    private int numFailureAttempts = 0;

    public boolean validate(String username, String password) {
        // This is a mock for actual authentication. In a real-world application,
        // this should use a secure method to compare the input password with the
        // hashed version in the database.
        boolean isValid = false;
        if ("test".equals(username) && "password".equals(password)) {
            isValid = true;
        } else {
            numFailureAttempts++;
            if (numFailureAttempts >= MAX_FAILURE_ATTEMPTS) {
                System.out.println("Maximum failure attempts reached. Locking account...");
            } else {
                System.out.println("Invalid credentials. Please try again.");
            }
        }
        return isValid;
    }

}