import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class java_31765_CredentialValidator_A01 {

    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    private static final Map<String, String> VALID_PASSWORDS = new HashMap<String, String>() {
        {
            put("password", "hashed_password");
            put("admin", "hashed_password");
        }
    };

    public boolean isValidEmail(String email) {
        return VALID_EMAIL_ADDRESS_REGEX.matcher(email).matches();
    }

    public boolean isValidPassword(String password) {
        if (VALID_PASSWORDS.containsKey(password)) {
            return true;
        } else {
            // Hash the password before comparing
            String hashedPassword = hashPassword(password);
            return hashedPassword.equals(VALID_PASSWORDS.get(password));
        }
    }

    private String hashPassword(String password) {
        byte[] hashedPassword = getMd5Signature(password);
        return Base64.getEncoder().encodeToString(hashedPassword);
    }

    private byte[] getMd5Signature(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return md.digest(input.getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}