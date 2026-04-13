import java.security.InvalidParameterException;
import java.util.Base64;

public class java_13195_CredentialValidator_A07 {

    private static final String SALT = "salt"; // Salting value
    private static final String SALTED_SHA256 = "saltedSHA256"; // SALTed SHA256

    private String userCredential;
    private String hashedCredential;
    private String toBeHashed;

    public java_13195_CredentialValidator_A07(String userCredential) {
        this.userCredential = userCredential;
    }

    public void setHashedCredential(String hashedCredential) {
        this.hashedCredential = hashedCredential;
    }

    public void setToBeHashed(String toBeHashed) {
        this.toBeHashed = toBeHashed;
    }

    public void validate() throws InvalidParameterException {
        if (hashedCredential == null || toBeHashed == null) {
            throw new InvalidParameterException("Must set both hashed credential and to be hashed value");
        }

        String saltedSHA256 = hashWithSalt(SALT, toBeHashed);

        if (!saltedSHA256.equals(hashedCredential)) {
            throw new InvalidParameterException("Invalid credentials");
        }
    }

    private String hashWithSalt(String salt, String toBeHashed) {
        String saltedPassword = salt + toBeHashed;
        byte[] saltedPasswordBytes = saltedPassword.getBytes();
        byte[] hashedPasswordBytes = getSHA256Hash(saltedPasswordBytes);
        String hashedPassword = Base64.getEncoder().encodeToString(hashedPasswordBytes);
        return hashedPassword;
    }

    private byte[] getSHA256Hash(byte[] saltedPasswordBytes) {
        MessageDigest digest;
        byte[] hash;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            digest.update(saltedPasswordBytes);
            hash = digest.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return hash;
    }
}