import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_40159_CredentialValidator_A03 {

    private static class UserCredential {
        private String username;
        private String password;

        public java_40159_CredentialValidator_A03(String username, String password) {
            this.username = username;
            this.password = hashPassword(password);
        }

        private String hashPassword(String password) {
            MessageDigest md;
            try {
                md = MessageDigest.getInstance("SHA-256");
                byte[] hash = md.digest(password.getBytes());
                return bytesToHex(hash);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
           .
.
.
.
                // Handle other exceptions if necessary
                return null;
            }
        }

        private String bytesToHex(byte[] bytes) {
            StringBuilder hexString = new StringBuilder();
            for (byte b : bytes) {
                String hex = Integer.toHexString(0xff & b);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        }

        public boolean isValidPassword(String password) {
            return this.password.equals(hashPassword(password));
        }
    }

    private UserCredential user;

    public java_40159_CredentialValidator_A03(String username, String password) {
        user = new UserCredential(username, password);
    }

    public boolean validate(String username, String password) {
        return user.isValidPassword(password);
    }
}