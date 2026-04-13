import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_36099_CredentialValidator_A01 implements CredentialValidator {

    private static final Pattern VALID_PASSWORD_PATTERN;

    static {
        StringBuilder sb = new StringBuilder("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$");
        VALID_PASSWORD_PATTERN = Pattern.compile(sb.toString());
    }

    @Override
    public boolean validate(String password) {
        Matcher matcher = VALID_PASSWORD_PATTERN.matcher(password);
        return matcher.matches();
    }
}