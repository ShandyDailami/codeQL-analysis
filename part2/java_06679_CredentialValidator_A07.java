public class java_06679_CredentialValidator_A07 {

    // CredentialValidator interface
    interface CredentialValidator {
        boolean validate(Credential credential);
    }

    // Credential class
    static class Credential {
        String username;
        String password;

        public java_06679_CredentialValidator_A07(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }

    // CredentialValidator implementation
    static class CustomCredentialValidator implements CredentialValidator {
        // Here you can add any logic related to authentication
        // For simplicity, we will just check if the username is "admin" and the password is "password"
        @Override
        public boolean validate(Credential credential) {
            return "admin".equals(credential.username) && "password".equals(credential.password);
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CustomCredentialValidator();

        // Use the validator
        Credential credential = new Credential("admin", "password");
        if (validator.validate(credential)) {
            System.out.println("Valid credentials");
        } else {
            System.out.println("Invalid credentials");
        }
    }
}