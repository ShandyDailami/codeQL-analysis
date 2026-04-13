import java.util.regex.Pattern;

public class java_38485_CredentialValidator_A07 {
    private static final String SPECIAL_CHARACTERS = "~!@#$%^&*()_+`={}|[]\\\\:;<>,.?\\[\\]\\\\\\`";

    public boolean validatePassword(String password) {
        if (password == null) {
            return false;
        }

        boolean upperCase = Pattern.matches(".*[A-Z].*", password);
        boolean lowerCase = Pattern.matches(".*[a-z].*", password);
        boolean specialChar = Pattern.matches(".*[" + SPECIAL_CHARACTERS + "].*", password);
        boolean minLength = password.length() >= 8;

        return upperCase && lowerCase && specialChar && minLength;
    }
}