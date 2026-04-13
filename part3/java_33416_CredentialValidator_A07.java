import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_33416_CredentialValidator_A07 {

    public static class UserCredentials {
        private String username;
        private String password;

        public java_33416_CredentialValidator_A07(String username, String password) {
            this.username = username;
            this.password = hashPassword(password);
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

        public boolean isValid(String username, String password) {
            return this.username.equals(username) && this.password.equals(hashPassword(password));
        }
    }

    public static void main(String[] args) {
        UserCredentials validator = new UserCredentials("admin", "password");

        if (validator.isValid("admin", "password")) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are not valid.");
        }

        if (validator.isValid("wrongUser", "password")) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are not valid.");
        }

        if (validator.isValid("admin", "wrongPassword")) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are not valid.");
        }
    }
}