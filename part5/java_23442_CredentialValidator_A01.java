public class java_23442_CredentialValidator_A01 implements CredentialValidator {

    private static final String SALT = "ThisIsASalt";

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationException {
        String name = credential.getIdentifier();
        String password = new String(credential.getCredentials());

        // Here, we simulate a real security check by comparing the password
        // with a hashed version stored in a database. In a real-world scenario,
        // you would use a library to hash the password and compare to the stored hash.
        // In this example, we just compare the password with a static salt.

        if (password.equals(getHashedPassword(name))) {
            return true;
        } else {
            throw new AuthenticationException("Invalid password");
        }
    }

    private String getHashedPassword(String name) {
        // Here, we simulate a real security hash by appending a salt and hashing.
        // In a real-world scenario, you would use a library to hash the password.
        // In this example, we just return a static hashed password.
        return hashPassword(name + SALT);
    }

    private String hashPassword(String password) {
        // Here, we simulate a real security hash by hashing the password.
        // In a real-world scenario, you would use a library to hash the password.
        // In this example, we just return the hashed password.
        return password;
    }
}