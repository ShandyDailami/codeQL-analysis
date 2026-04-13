public class java_09562_CredentialValidator_A01 {

    public static final String SALT = "salt";

    public static class User {
        private String username;
        private String password;
        private String encryptedPassword;

        public java_09562_CredentialValidator_A01(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public void setEncryptedPassword(String encryptedPassword) {
            this.encryptedPassword = encryptedPassword;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public String getEncryptedPassword() {
            return encryptedPassword;
        }
    }

    public static class CredentialValidator {

        public boolean validate(User user, String passwordAttempt) {
            // Legacy method: salt+encrypted password equals to encrypted password
            return user.getEncryptedPassword().equals(encryptPassword(passwordAttempt));
        }

        private String encryptPassword(String password) {
            // Legacy method: encrypt password with a unique salt
            return encrypt(password + SALT);
        }

        private String encrypt(String message) {
            // This is a placeholder for a real-world encryption method
            // It should be replaced with a real encryption method suitable for the context of the legacy system
            // This is a simple demonstration and real encryption methods will be more complex
            return message;
        }
    }

    public static void main(String[] args) {
        User user = new User("username", "password");
        CredentialValidator validator = new CredentialValidator();
        validator.validate(user, "wrongPassword");
        user.setEncryptedPassword(validator.encryptPassword("password"));
        validator.validate(user, "password");
    }
}