public class java_12135_CredentialValidator_A01 implements CredentialValidator {

    private static final String SALT = "SaltForPassword";

    @Override
    public boolean validate(Credential c) {
        String enteredPassword = c.getPassword();
        String hashedPassword = getHashedPassword(SALT + c.getUsername());
        return enteredPassword.equals(hashedPassword);
    }

    private String getHashedPassword(String password) {
        // In a real-world scenario, you would typically use a cryptographic hash function to hash the password
        // Here, we're just simulating this by returning a hash of the password
        return password;
    }
}