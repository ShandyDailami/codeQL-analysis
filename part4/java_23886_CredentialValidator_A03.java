public class java_23886_CredentialValidator_A03 {
    // Simple class to represent a user and their credentials
    public static class User {
        private String username;
        private String password;

        public java_23886_CredentialValidator_A03(String username, String password) {
            this.username = username;
            this.password = password;
        }

        // Getters and Setters
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    // Our CredentialValidator class
    public static class CredentialValidator {
        private List<User> userDatabase;

        public java_23886_CredentialValidator_A03() {
            userDatabase = new ArrayList<>();
            userDatabase.add(new User("user1", "password1"));
            userDatabase.add(new User("user2", "password2"));
            userDatabase.add(new User("user3", "password3"));
        }

        public boolean validateCredentials(String username, String password) {
            for (User user : userDatabase) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Test valid credentials
        boolean isValid = validator.validateCredentials("user1", "password1");
        System.out.println("Is valid: " + isValid);

        // Test invalid credentials
        isValid = validator.validateCredentials("invalid", "invalid");
        System.out.println("Is valid: " + isValid);
    }
}