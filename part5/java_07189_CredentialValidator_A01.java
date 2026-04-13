public class java_07189_CredentialValidator_A01 {

    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final String SPECIFIED_PASSWORD = "password123";

    public boolean validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        if (password.length() < MIN_PASSWORD_LENGTH) {
            System.out.println("Password is too short. It should be at least " + MIN_PASSWORD_LENGTH + " characters long.");
            return false;
        }

        if (!password.equals(SPECIFIED_PASSWORD)) {
            System.out.println("Password is incorrect.");
            return false;
        }

        System.out.println("Access granted!");
        return true;
    }
}