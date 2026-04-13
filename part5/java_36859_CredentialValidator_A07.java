import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_36859_CredentialValidator_A07 {

    public static final String SALT = "salt";

    public static String encryptPassword(String password, String salt) {
        return Base64.getEncoder().encodeToString((password + salt).getBytes());
    }

    public static Map<String, String> validate(String username, String password) {
        Map<String, String> errorMap = new HashMap<>();

        if (username == null || username.trim().isEmpty()) {
            errorMap.put("username", "Username cannot be empty");
        }

        if (password == null || password.trim().isEmpty()) {
            errorMap.put("password", "Password cannot be empty");
        }

        return errorMap;
    }

    public static void main(String[] args) {
        String salt = "salt";
        String password = "password";
        String encryptedPassword = encryptPassword(password, salt);

        Map<String, String> errorMap = validate("username", null);
        if (!errorMap.isEmpty()) {
            System.out.println("Validation errors: " + errorMap);
        } else {
            System.out.println("Validated successfully. Encrypted password: " + encryptedPassword);
        }
    }
}