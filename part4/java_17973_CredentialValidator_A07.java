public class java_17973_CredentialValidator_A07 {
    public static void main(String[] args) {
        Credential credential = new Credential("user", "password");
        validate(credential);
    }

    public static void validate(Credential credential) {
        if (isValid(credential)) {
            System.out.println("Valid credential");
        } else {
            System.out.println("Invalid credential");
        }
    }

    public static boolean isValid(Credential credential) {
        // Here we'll just simulate a failed authentication
        return !simulateAuthentication(credential);
    }

    public static boolean simulateAuthentication(Credential credential) {
        // Here we'll simulate a failed authentication
        if (credential.getUsername().equals("user") && credential.getPassword().equals("password")) {
            return true;
        } else {
            return false;
        }
    }

    public static class Credential {
        private String username;
        private String password;

        public java_17973_CredentialValidator_A07(String username, String password) {
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
}