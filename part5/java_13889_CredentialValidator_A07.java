import java.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_13889_CredentialValidator_A07 {

    public static class CustomCredential {
        private String username;
        private String password;

        public java_13889_CredentialValidator_A07(String username, String password) {
            this.username = username;
            this.password = hashPassword(password);
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        private String hashPassword(String password) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte[] hash = md.digest(password.getBytes());
                return Base64.getEncoder().encodeToString(hash);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public static class CustomCredentialValidator {
        private CustomCredential[] credentials;

        public java_13889_CredentialValidator_A07(CustomCredential[] credentials) {
            this.credentials = credentials;
        }

        public boolean validateCredentials(String username, String password) {
            for (CustomCredential credential : credentials) {
                if (credential.getUsername().equals(username) && credential.getPassword().equals(hashPassword(password))) {
                    return true;
                }
            }
            return false;
        }

        private String hashPassword(String password) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte[] hash = md.digest(password.getBytes());
                return Base64.getEncoder().encodeToString(hash);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}