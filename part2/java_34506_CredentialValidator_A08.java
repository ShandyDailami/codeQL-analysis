import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_34506_CredentialValidator_A08 {

    private static final Pattern complexityPattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&*])(?=\\S+$).{8,}$");
    private static final Pattern specialCharacterPattern = Pattern.compile("[@#$%^&*]");
    private static final Pattern numericPattern = Pattern.compile("[0-9]");
    private static final Pattern uppercasePattern = Pattern.compile("[A-Z]");
    private static final Pattern lowercasePattern = Pattern.compile("[a-z]");

    public boolean isValidPassword(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        Matcher matcher = complexityPattern.matcher(password);
        if (!matcher.matches()) {
            System.out.println("Password must include at least one numeric character, one uppercase character, one lowercase character, and one special character");
            return false;
        }

        matcher = specialCharacterPattern.matcher(password);
        if (matcher.find()) {
            System.out.println("Password must include at least one special character (@#$%^&*)");
            return false;
        }

        matcher = numericPattern.matcher(password);
        if (matcher.find()) {
            System.out.println("Password must include at least one numeric character");
            return false;
        }

        matcher = uppercasePattern.matcher(password);
        if (matcher.find()) {
            System.out.println("Password must include at least one uppercase character");
            return false;
        }

        matcher = lowercasePattern.matcher(password);
        if (matcher.find()) {
            System.out.println("Password must include at least one lowercase character");
            return false;
        }

        return true;
    }
}