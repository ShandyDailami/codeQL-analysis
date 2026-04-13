public class java_08611_CredentialValidator_A08 {

    private String[] validPasswords;

    public java_08611_CredentialValidator_A08(String[] validPasswords) {
        this.validPasswords = validPasswords;
    }

    public boolean validate(String password) {
        // For simplicity, we'll just check if the password is in our list of valid passwords.
        // In a real application, you would likely want to hash the password and compare the hashes.
        for (String validPassword : validPasswords) {
            if (validPassword.equals(password)) {
                return true;
            }
        }
        return false;
    }
}