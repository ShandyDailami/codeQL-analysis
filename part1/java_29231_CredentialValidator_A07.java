public class java_29231_CredentialValidator_A07 implements CredentialValidator {
    private static final String SALT = "salt";
    private static final String HASH_ALGORITHM = "SHA-256";

    @Override
    public byte[] validate(String id) throws InvalidAlgorithmParameterException, NoSuchAlgorithmException {
        // Step 1: Create the hash to be compared against
        MessageDigest md = MessageDigest.getInstance(HASH_ALGORITHM);
        md.update(SALT.getBytes());
        byte[] hash = md.digest(id.getBytes());

        // Step 2: Compare the hash against the stored hash
        // Assume we have a stored hash stored in a variable 'storedHash'
        if (Arrays.equals(hash, storedHash)) {
            return hash;
        } else {
            throw new AuthenticationFailedException("Authentication failed");
        }
    }
}