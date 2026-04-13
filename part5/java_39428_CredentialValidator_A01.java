import java.util.regex.Pattern;

public class java_39428_CredentialValidator_A01 {
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";
    private static final String UPPERCASE_LETTERS = "QWERTYUIOPASDFGHJKLZXCVBNM";
    private static final String LOWERCASE_LETTERS = "qwertyuiopasdfghjklzxcvbnm";
    private static final String NUMBERS = "1234567890";
    private static final Pattern PASSWORD_PATTERN;

    static {
        StringBuilder pattern = new StringBuilder("^(?=.*[");
        pattern.append(UPPERCASE_LETTERS);
        pattern.append("])(?=.*[");
        pattern.append(LOWERCASE_LETTERS);
        pattern.append("])(?=.*[");
        pattern.append(NUMBERS);
        pattern.append("])(?=.*/.$");
        pattern.append(SPECIAL_CHARACTERS);
        pattern.append("]).{8,}$");
        PASSWORD_PATTERN = Pattern.compile(pattern.toString());
    }

    public boolean validate(String password) {
        return PASSWORD_PATTERN.matcher(password).matches();
    }
}