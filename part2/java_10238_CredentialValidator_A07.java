public class java_10238_CredentialValidator_A07 implements CredentialValidator {

    private final UserDatabase database;

    public java_10238_CredentialValidator_A07(UserDatabase database) {
        this.database = database;
    }

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws CredentialException {
        String username = credential.getIdentifier();
        char[] password = credential.getPassword();

        // Fetch user from database using username
        User user = database.fetchUser(username);

        // Check if user exists in the database
        if (user == null) {
            throw new CredentialException("User not found.");
        }

        // Check if password matches in the database
        if (!user.getPassword().equals(new String(password))) {
            throw new CredentialException("Invalid password.");
        }

        return true;
    }
}