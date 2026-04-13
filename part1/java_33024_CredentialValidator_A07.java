import java.util.regex.Pattern;

public class java_33024_CredentialValidator_A07 {
    private static final String SPECIAL_CHARACTERS = "@$!%^&*()_+";
    private static final String SPECIAL_CHARACTERS_REGEX = "[" + Pattern.quote(SPECIAL_CHARACTERS) + "]";
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[" + SPECIAL_CHARACTERS_REGEX + "]).{8,}$");

    public static boolean isStrongPassword(String password) {
        return PASSWORD_PATTERN.matcher(password).matches();
    }
}