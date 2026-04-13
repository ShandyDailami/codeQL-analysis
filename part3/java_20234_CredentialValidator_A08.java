// package declaration
package a08_IntegrityFailure;

// import necessary classes
import java.security.Credential;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpec;
import java.util.Base64;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

// class java_20234_CredentialValidator_A08
public class CredentialValidator {
    
    // method for generating key
    private SecretKey getKey(String password, byte[] salt) throws NoSuchAlgorithmException {
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 10000, 256);
        SecretKey key = factory.generateSecret(spec);
        return new SecretKeySpec(key.getEncoded(), "AES");
    }
    
    // method for verifying password
    public boolean validatePassword(String password, String passwordInDatabase) throws NoSuchAlgorithmException, InvalidKeySpec {
        byte[] salt = getSalt();
        byte[] hashedPassword = getKey(password, salt).getEncoded();
        byte[] hashedDatabasePassword = Base64.getDecoder().decode(passwordInDatabase);
        return Arrays.equals(hashedPassword, hashedDatabasePassword);
    }

    // method for generating salt
    private byte[] getSalt() throws NoSuchAlgorithmException {
        return java.util.UUID.randomUUID().toString().getBytes();
    }
}