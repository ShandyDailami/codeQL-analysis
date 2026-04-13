import java.util.Base64;

public class java_33822_CredentialValidator_A03 {

    public static class Credentials {
        private String username;
        private String password;

        public java_33822_CredentialValidator_A03(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }

    public static class CredentialValidator {
        public boolean validate(Credentials credentials) {
            // This is a dummy check. In a real application, you would actually
            // compare the password with a hashed version stored in a database.
            return isValidUsername(credentials.getUsername()) && isValidPassword(credentials.getPassword());
        }

        private boolean isValidUsername(String username) {
            // This is a dummy check. In a real application, you would use a
            // database or a more secure method to check the username against a
            // list of valid usernames.
            return username != null && !username.isEmpty();
        }

        private boolean isValidPassword(String password) {
            // This is a dummy check. In a real application, you would use a
            // database or a more secure method to check the password against a
            // list of valid passwords.
            return password != null && !password.isEmpty();
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        Credentials credentials = new CredentialValidator.Credentials("admin", "password");
        if (validator.validate(credentials)) {
            System.out.println("Valid credentials");
        } else {
            System.out.println("Invalid credentials");
        }
    }
}