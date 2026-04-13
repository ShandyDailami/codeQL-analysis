public class java_27552_CredentialValidator_A01 implements CredentialValidator {

    @Override
    public boolean validate(String password) {
        // a password is considered strong enough if it has at least 8 characters, 
        // and includes at least one uppercase letter, one lowercase letter, and one digit
        if (password.length() < 8) {
            return false;
        }
        if (!password.matches(".*[a-z].*")) {
            return false;
        }
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }
        if (!password.matches(".*\\d.*")) {
            return false;
        }
        return true;
    }
}