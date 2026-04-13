public class java_29602_CredentialValidator_A08 {

    public static class User {
        private String password;

        public java_29602_CredentialValidator_A08(String password) {
            this.password = password;
        }

        public String getPassword() {
            return password;
        }
    }

    public static class Credential {
        private User user;
        private String password;

        public java_29602_CredentialValidator_A08(User user, String password) {
            this.user = user;
            this.password = password;
        }

        public User getUser() {
            return user;
        }

        public String getPassword() {
            return password;
        }
    }

    public static class CredentialValidator {
        public boolean validate(Credential credential) throws Exception {
            User user = credential.getUser();
            String inputPassword = credential.getPassword();

            // Simulate integrity failure by comparing the input password with the stored password.
            if (user.getPassword().equals(inputPassword)) {
                return true;
            } else {
                throw new Exception("Invalid password");
            }
        }
    }
}