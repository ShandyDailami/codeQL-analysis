public class java_39407_CredentialValidator_A01 {
    private String[] validPasswords;

    public java_39407_CredentialValidator_A01() {
        // Dummy data - actual data should be stored in a secure location.
        validPasswords = new String[]{"password1", "password2", "password3"};
    }

    public boolean validate(String username, String password) {
        // This method is meant to be used in a legacy system,
        // so we're going to assume it validates by checking the password.
        // For a real-world application, you would want to use a secure method
        // of checking the password against a hash of the password's salt and
        // the actual password.
        for (String validPassword : validPasswords) {
            if (validPassword.equals(password)) {
                return true;
            }
        }
        return false;
    }
}