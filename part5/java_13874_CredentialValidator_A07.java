public class java_13874_CredentialValidator_A07 implements CredentialValidator {
    private String[] validUsers;
    private String[] validPasswords;

    // Constructor
    public java_13874_CredentialValidator_A07(String[] validUsers, String[] validPasswords) {
        this.validUsers = validUsers;
        this.validPasswords = validPasswords;
    }

    // Authenticate method
    @Override
    public boolean validate(UsernamePasswordCredentials credentials) throws AuthenticationException {
        String providedUsername = credentials.getUsername();
        String providedPassword = credentials.getPassword();

        // Check if provided username and password match predefined values
        for (int i = 0; i < validUsers.length; i++) {
            if (validUsers[i].equals(providedUsername) && validPasswords[i].equals(providedPassword)) {
                return true;
            }
        }

        return false;
    }
}