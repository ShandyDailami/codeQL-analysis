public class java_12507_CredentialValidator_A07 {

    public static void main(String[] args) {
        Credential credential = new Credential();
        credential.setUsername("test");
        credential.setPassword("password");

        CredentialValidator validator = new CredentialValidator() {
            @Override
            public boolean validate(Credential credential) throws Exception {
                if (credential.getUsername().equals("test") && credential.getPassword().equals("password")) {
                    return true;
                } else {
                    return false;
                }
            }
        };

        try {
            if (validator.validate(credential)) {
                System.out.println("Credentials are valid");
            } else {
                System.out.println("Credentials are invalid");
            }
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

    public static class Credential {
        private String username;
        private String password;

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

    public interface CredentialValidator {
        boolean validate(Credential credential) throws Exception;
    }
}