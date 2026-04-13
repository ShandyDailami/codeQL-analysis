import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;

import javax.security.auth.Subject;
import javax.security.auth.login.CredentialValidationResult;
import javax.security.auth.login.LoginException;
import javax.security.auth.validation.DefaultValidationResult;
import javax.security.auth.validation.Validator;
import javax.security.auth.validation.ValidationResult;

public class java_14339_CredentialValidator_A07 implements Validator {
    // Storing the hashed version of the password
    private String storedPassword = "$argon2id$v=19$m=65536,t=4,p=1$";

    @Override
    public ValidationResult validate(Subject subject, Principal principal,
                                    Object credentials) throws LoginException {
        String passwordAttempt = credentials.toString();

        // Hash the password provided by the user
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(passwordAttempt.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            String hashedPasswordAttempt = sb.toString();

            // Compare the hashed password attempt with the stored password
            if (hashedPasswordAttempt.equals(storedPassword)) {
                return new DefaultValidationResult("Success");
            } else {
                return new DefaultValidationResult("Failure");
            }
        } catch (NoSuchAlgorithmException e) {
            throw new LoginException(e);
        }
    }
}