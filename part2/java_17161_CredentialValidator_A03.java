import java.util.Base64;

public class java_17161_CredentialValidator_A03 {

    private static final String SALT = "salt";

    public static class SimpleCredentialValidator implements CredentialValidatorIfc {

        private static final String USERNAME_KEY = "username";
        private static final String PASSWORD_KEY = "password";

        @Override
        public boolean validate(String username, String password) {
            return isPasswordValid(username, password);
        }

        private boolean isPasswordValid(String username, String password) {
            return verifyPassword(username, password);
        }

        private boolean verifyPassword(String username, String password) {
            return isPasswordEqual(username, password);
        }

        private boolean isPasswordEqual(String username, String password) {
            return username.equals(usernameFromCredentials(password)) &&
                    password.equals(passwordFromCredentials(username));
        }

        private String usernameFromCredentials(String password) {
            return new String(Base64.getDecoder().decode(password));
        }

        private String passwordFromCredentials(String username) {
            return Base64.getEncoder().encodeToString(username.getBytes());
        }
    }

    public static void main(String[] args) {
        CredentialValidator.SimpleCredentialValidator simpleCredentialValidator = new CredentialValidator.SimpleCredentialValidator();

        System.out.println(simpleCredentialValidator.validate("alice", "password")); // true
        System.out.println(simpleCredentialValidator.validate("bob", "wrongPassword")); // false
    }
}