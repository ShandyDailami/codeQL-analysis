public class java_35264_CredentialValidator_A03 {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        Credential credential = new Credential("user", "password");

        if (validator.validate(credential)) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are not valid.");
        }
    }
}

class Credential {
    private String username;
    private String password;

    public java_35264_CredentialValidator_A03(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and setters
}

class CredentialValidator {
    public boolean validate(Credential credential) {
        // This is a very basic validation process. In a real-world scenario,
        // you would likely use a more complex validation process, possibly involving
        // a database or external service to look up the credentials.

        if (credential.getUsername().equals("user") && credential.getPassword().equals("password")) {
            return true;
        } else {
            return false;
        }
    }
}