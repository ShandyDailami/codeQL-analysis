public class java_09950_CredentialValidator_A08 {
    // Assume there is a method validate() that takes two strings and returns a boolean
    public boolean validate(String username, String password) {
        // Assume we have some predefined users and passwords
        if (username.equals("admin") && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }
}

public class CredentialValidator {
    private Credential credential;

    public java_09950_CredentialValidator_A08(Credential credential) {
        this.credential = credential;
    }

    public boolean validateCredential(String username, String password) {
        // Use the credential object to validate the credentials
        return credential.validate(username, password);
    }
}

public class Main {
    public static void main(String[] args) {
        Credential credential = new Credential();
        CredentialValidator credentialValidator = new CredentialValidator(credential);

        boolean isValid = credentialValidator.validateCredential("admin", "password");
        if (isValid) {
            System.out.println("Credentials are valid");
        } else {
            System.out.println("Credentials are not valid");
        }
    }
}