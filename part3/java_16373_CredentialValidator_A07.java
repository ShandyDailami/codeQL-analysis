import java.security.Key;
import java.security.KeyStore;
import java.security.cert.X509Certificate;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class java_16373_CredentialValidator_A07 implements ConstraintValidator<ValidPassword, String> {

    private final AuthenticationProvider authenticationProvider;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public java_16373_CredentialValidator_A07(AuthenticationProvider authenticationProvider, PasswordEncoder passwordEncoder) {
        this.authenticationProvider = authenticationProvider;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if (password == null) {
            return false;
        }
        if (password.length() < 8) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Password is too short. It should be at least {0} characters")
                    .addConstraintViolation();
            return false;
        }
        if (!password.matches(".*[0-9].*")) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Password should have at least one numeric character")
                    .addConstraintViolation();
            return false;
        }
        if (!password.matches(".*[A-Z].*")) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Password should have at least one uppercase character")
                    .addConstraintViolation();
            return false;
        }
        if (!password.matches(".*[a-z].*")) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Password should have at least one lowercase character")
                    .addConstraintViolation();
            return false;
        }
        if (!password.matches(".*[!@#$%^&*()_+-={}\\[\\]:\";'<>,.?].*")) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Password should have at least one special character")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }

}