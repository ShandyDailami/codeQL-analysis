public class java_07979_CredentialValidator_A03 {
    public static class Credential {
        private String username;
        private String password;

        public java_07979_CredentialValidator_A03(String username, String password) {
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

    public boolean validate(Credential credential) {
        // Here you can add your security sensitive operations like checking against a database, hashing the password before comparing
        if (credential.getUsername().equals("admin") && credential.getPassword().equals("password")) {
            return true;
        } else {
            return false;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        Credential credential = new Credential("admin", "password");
        CredentialValidator validator = new CredentialValidator();

        if (validator.validate(credential)) {
            System.out.println("Validated successfully!");
        } else {
            System.out.println("Failed to validate!");
        }
    }
}