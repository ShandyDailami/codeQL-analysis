import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.regex.Pattern;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.validator.routines.PasswordStrengthValidator;
import org.springframework.security.authentication.credential.CredentialValidator;
import org.springframework.security.authentication.credential.PasswordEncoder;
import org.springframework.security.authentication.credential.PasswordValidator;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class java_22448_CredentialValidator_A07 implements CredentialValidator {

    private final PasswordEncoder passwordEncoder;
    private final PasswordValidator passwordValidator;

    public java_22448_CredentialValidator_A07() throws NoSuchAlgorithmException {
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.passwordValidator = new PasswordStrengthValidator();
    }

    @Override
    public boolean validate(UserDetails user, String presentedPassword) {
        String encryptedPassword = user.getPassword();
        String presentedPasswordStrength = passwordValidator.validate(presentedPassword).name();
        String encryptedPresentedPassword = DigestUtils.sha256Hex(presentedPassword);

        // Check if the presented password is strong enough
        if (!presentedPasswordStrength.equals("Very Strong")) {
            return false;
        }

        // Check if the presented password is the same as the user's password
        return passwordEncoder.matches(encryptedPresentedPassword, encryptedPassword);
    }
}