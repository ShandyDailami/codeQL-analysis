import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_29079_CredentialValidator_A03 {
    private static final String[][] credentials = {
        {"alice", "123"},
        {"bob", "456"},
        {"charlie", "789"}
    };

    public static class Validator implements java.security.AuthenticationValidator {
        @Override
        public String validate(java.security.Authentication authentication) {
            String user = authentication.getName();
            String password = new String(authentication.getCredentials());

            for (String[] credential : credentials) {
                if (credential[0].equals(user) && arePasswordsEqual(credential[1], password)) {
                    return null; // valid credentials
                }
            }

            return "Invalid credentials.";
        }

        private boolean arePasswordsEqual(String expected, String actual) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte[] hash1 = md.digest(expected.getBytes());
                byte[] hash2 = md.digest(actual.getBytes());

                return MessageDigest.isEqual(hash1, hash2);
            } catch (NoSuchAlgorithmException e) {
                // SHA-256 is a valid algorithm
                return expected.equals(actual);
            }
        }
    }
}