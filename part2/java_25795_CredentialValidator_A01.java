public class java_25795_CredentialValidator_A01 {

    public static void main(String[] args) {
        CustomCredentialValidator validator = new CustomCredentialValidator();
        Credential credential = validator.getCredential("admin", "password");
        if (credential != null) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are invalid.");
        }
    }

    public Credential getCredential(String username, String password) {
        // Implement the logic here to validate the username and password
        // Return null if the username or password is incorrect
        // Otherwise, return a new Credential object

        // For the purpose of this example, we will return a valid Credential
        // for a username and password of "admin" and "password" respectively
        return new Credential(username, password);
    }

    public static class Credential {
        private String username;
        private String password;

        public java_25795_CredentialValidator_A01(String username, String password) {
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