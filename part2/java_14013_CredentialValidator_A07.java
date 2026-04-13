import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_14013_CredentialValidator_A07 {
    // The password to be validated
    private String passwordToValidate;

    // The hash of the expected password
    private String expectedPasswordHash;

    // The length of the expected password
    private int expectedPasswordLength;

    public java_14013_CredentialValidator_A07(String passwordToValidate, String expectedPasswordHash, int expectedPasswordLength) {
        this.passwordToValidate = passwordToValidate;
        this.expectedPasswordHash = expectedPasswordHash;
        this.expectedPasswordLength = expectedPasswordLength;
    }

    public boolean isPasswordValid() {
        // If the passwords don't match or are too short, return false
        if (!passwordToValidate.equals(expectedPasswordHash) || passwordToValidate.length() < expectedPasswordLength) {
            return false;
        }

        // If they match, check the password's strength
        if (passwordToValidate.length() < 8) {
            return false;
        }

        // If they match and are at least 8 characters long, check if they contain uppercase, lowercase, number, and special character
        if (!(passwordToValidate.matches(".*[A-Z].*")) || !(passwordToValidate.matches(".*[a-z].*")) || !(passwordToValidate.matches(".*[0-9].*")) || !(passwordToValidate.matches(".*[!@#\\$%\\^&\\*].*"))) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        try {
            String passwordToValidate = "password";
            String expectedPasswordHash = hashPassword(passwordToValidate);
            int expectedPasswordLength = passwordToValidate.length();

            CredentialValidator validator = new CredentialValidator(passwordToValidate, expectedPasswordHash, expectedPasswordLength);
            if (validator.isPasswordValid()) {
                System.out.println("Password is valid");
            } else {
                System.out.println("Password is not valid");
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hashBytes = md.digest(password.getBytes());
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < hashBytes.length; i++){
            sb.append(Integer.toString((hashBytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
}