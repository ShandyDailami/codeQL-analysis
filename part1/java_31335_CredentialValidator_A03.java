import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import java.security.InvalidKeyException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidatorResult;

public class java_31335_CredentialValidator_A03 implements CredentialValidator {

    private static final Pattern USERNAME_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[._-]).{8,}$");

    @Override
    public CredentialValidatorResult validate(Credentials credentials) {
        String username = credentials.getUsername();
        String password = credentials.getPassword();

        if (!USERNAME_PATTERN.matcher(username).matches()) {
            return CredentialValidatorResult.invalidCredentials();
        }

        if (!PASSWORD_PATTERN.matcher(password).matches()) {
            return CredentialValidatorResult.invalidCredentials();
        }

        return CredentialValidatorResult.success();
    }

    public static class Credentials {
        private String username;
        private String password;

        public java_31335_CredentialValidator_A03(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }
}