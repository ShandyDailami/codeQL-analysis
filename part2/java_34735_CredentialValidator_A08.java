import java.util.regex.Pattern;
import java.security.SecureRandom;
import org.javalang.security.PasswordUtils;
import org.javalang.security.PasswordMetrics;
import org.javalang.security.Strength;

public class java_34735_CredentialValidator_A08 {
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";
    private static final String NUMBERS = "0123456789";
    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";

    private static final SecureRandom random = new SecureRandom();
    private static final Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[" + SPECIAL_CHARACTERS + "]).{8,}$");

    public static boolean isPasswordStrong(String password) {
        PasswordMetrics metrics = new PasswordMetrics(password);
        Strength strength = PasswordUtils.test(password, metrics);

        return strength == Strength.MEDIUM || strength == Strength.WEAK;
    }

    public static String generateStrongPassword() {
        StringBuilder password = new StringBuilder(8 + random.nextInt(26));

        password.append(LOWERCASE_LETTERS.charAt(random.nextInt(LOWERCASE_LETTERS.length())));
        password.append(UPPERCASE_LETTERS.charAt(random.nextInt(UPPERCASE_LETTERS.length())));
        password.append(NUMBERS.charAt(random.nextInt(NUMBERS.length())));
        password.append(SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length())));

        for(int i = 0; i < 4; i++) {
            password.append(LOWERCASE_LETTERS.charAt(random.nextInt(LOWERCASE_LETTERS.length())));
        }

        return password.toString();
    }
}