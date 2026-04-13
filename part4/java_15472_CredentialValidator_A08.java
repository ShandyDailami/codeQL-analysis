import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import java.security.InvalidAlgorithmParameterException;
import java.security.spec.InvalidParameterSpecException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.security.auth.CredentialValidator;
import javax.security.auth.login.CredentialException;

public class java_15472_CredentialValidator_A08 implements CredentialValidator {

    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
    private static final Pattern PASSWORD_PATTERN_OBJ = Pattern.compile(PASSWORD_PATTERN);

    @Override
    public String getNormPassword() {
        return null;
    }

    @Override
    public String getPassword(String arg0) {
        return null;
    }

    @Override
    public boolean validate(String arg0, String arg1) throws CredentialException {
        if (arg1 == null || arg1.length() == 0) {
            throw new CredentialException("Password cannot be null or empty");
        }

        Matcher matcher = PASSWORD_PATTERN_OBJ.matcher(arg1);
        if (!matcher.matches()) {
            throw new CredentialException("Password must be at least 8 characters long and contain a mix of uppercase letters, lowercase letters, numbers, and special characters");
        }

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(arg1.getBytes("UTF-8"));

            // Check the integrity of the password
            if (hash.length != 32) {
                throw new CredentialException("Invalid hash length, password is not strong enough");
            }

            // Validate the password again using SHA-256
            md.reset();
            byte[] passwordHash = md.digest(arg0.getBytes("UTF-8"));

            // Check the integrity of the password
            if (!MessageDigest.isEqual(hash, passwordHash)) {
                throw new CredentialException("Invalid password, password is not strong enough");
            }

            return true;

        } catch (NoSuchAlgorithmException | InvalidAlgorithmParameterException | InvalidParameterSpecException | java.lang.ExceptionInInitializerException e) {
            throw new CredentialException(e);
        }
    }
}