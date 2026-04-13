import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_39515_CredentialValidator_A03 {
    // Step 1: Implement the CredentialValidator interface
    public interface CredentialValidator {
        boolean isValid(String username, String password);
    }

    // Step 2: Implement the CredentialValidator interface
    public static class DefaultCredentialValidator implements CredentialValidator {
        private Key key;

        public java_39515_CredentialValidator_A03(Key key) {
            this.key = key;
        }

        @Override
        public boolean isValid(String username, String password) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                md.update(username.getBytes());
                byte[] bytes = md.digest(password.getBytes());

                // Step 3: Use a secure method to compare byte arrays
                return compareByteArrays(bytes, key);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                return false;
            }
        }

        private boolean compareByteArrays(byte[] a, byte[] b) {
            if (a.length != b.length)
                return false;
            for (int i = 0; i < a.length; i++) {
                if (a[i] != b[i]) return false;
            }
            return true;
        }
    }
}