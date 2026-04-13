public class java_27726_CredentialValidator_A01 implements CredentialValidator {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()_+=-[]{};':\",.<>?\\|`~";
    private static final String NUMBERS = "0123456789";
    private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @Override
    public boolean validate(String username, String password, boolean userMustExist) throws CredentialException {
        if (password == null) {
            throw new CredentialException("Password can't be null");
        }

        if (password.length() < 8) {
            throw new CredentialException("Password must be at least 8 characters long");
        }

        if (!(password.matches(".*[" + UPPER_CASE + "]+.*"))) {
            throw new CredentialException("Password must contain at least one uppercase letter");
        }

        if (!(password.matches(".*[" + LOWER_CASE + "]+.*"))) {
            throw new CredentialException("Password must contain at least one lowercase letter");
        }

        if (!(password.matches(".*[" + NUMBERS + "]+.*"))) {
            throw new CredentialException("Password must contain at least one numeral");
        }

        if (!(password.matches(".*[" + SPECIAL_CHARACTERS + "]+.*"))) {
            throw new CredentialException("Password must contain at least one special character");
        }

        return true;
    }
}