import java.security.InvalidParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class java_05140_CredentialValidator_A07 {

    public static boolean validate(String username, String password, String algorithm) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidParameterException {

        // Check if the algorithm exists
        if (!java.security.Security.getAlgorithms().contains(algorithm)) {
            throw new InvalidParameterException("Invalid algorithm");
        }

        // Get the hashed version of the password
        byte[] hashedPassword = getHashedPassword(password, algorithm);

        // Check if the password matches
        if (isPasswordMatch(hashedPassword, algorithm)) {
            return true;
        } else {
            throw new InvalidParameterException("Invalid password");
        }
    }

    private static byte[] getHashedPassword(String password, String algorithm) throws NoSuchAlgorithmException, InvalidKeySpecException {
        // Retrieve the hashed password using the specified algorithm
        java.security.MessageDigest md = java.security.MessageDigest.getInstance(algorithm);
        return md.digest(password.getBytes());
    }

    private static boolean isPasswordMatch(byte[] hashedPassword, String algorithm) throws NoSuchAlgorithmException, InvalidKeySpecException {
        // Retrieve the stored hashed password using the same algorithm
        java.security.MessageDigest md = java.security.MessageDigest.getInstance(algorithm);
        return java.util.Arrays.equals(md.digest(password.getBytes()), hashedPassword);
    }
}