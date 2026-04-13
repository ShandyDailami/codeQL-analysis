public class java_21787_CredentialValidator_A01 implements CredentialValidator {

    private String[] validPasswords;

    public java_21787_CredentialValidator_A01() {
        // Assuming valid passwords are hard-coded here for simplicity
        validPasswords = new String[]{"password", "admin", "user"};
    }

    @Override
    public boolean validate(String username, String password) {
        for (String validPassword : validPasswords) {
            if (validPassword.equals(password)) {
                return true;
            }
        }
        return false;
    }
}