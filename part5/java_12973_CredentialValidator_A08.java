import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_12973_CredentialValidator_A08 {

    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    public boolean isValidPassword(String password) {
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public boolean isValidEncodedPassword(String encodedPassword) {
        byte[] decodedBytes = Base64.getDecoder().decode(encodedPassword);
        String decodedPassword = new String(decodedBytes);
        return isValidPassword(decodedPassword);
    }

    public boolean isValidCredential(String credential) {
        if (credential.contains(":")) {
            String[] creds = credential.split(":");
            return isValidEncodedPassword(creds[1]);
        } else {
            return isValidPassword(credential);
        }
    }

}