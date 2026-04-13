public class java_08062_CredentialValidator_A03 implements CredentialValidator {

    private static final String SALT = "Salt_for_hashing";

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationException {
        String plainTextPassword = credential.getPasswordAsString();

        // Hash the password with a salt
        byte[] hashedPassword = hashPassword(plainTextPassword);

        // Compare hashed password with stored hashed password
        if (Arrays.equals(hashedPassword, storedHashedPassword)) {
            return true;
        } else {
            throw new AuthenticationException("Authentication failed");
        }
    }

    private byte[] hashPassword(String password) {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(SALT.getBytes());
        byte[] bytes = md.digest(password.getBytes());
        return bytes;
    }
}