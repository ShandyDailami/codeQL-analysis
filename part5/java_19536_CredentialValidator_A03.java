public class java_19536_CredentialValidator_A03 implements CredentialValidator {

    @Override
    public boolean validate(UsernamePasswordCredential credential) {
        String password = credential.getPasswordAsString();
        // The password should be at least 8 characters long and should contain at least one digit, one uppercase letter, one lowercase letter, and one special character
        if (password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&*])[a-zA-Z0-9@#$%^&*]{8,}$")) {
            return true;
        } else {
            return false;
        }
    }
}