import java.util.Base64;
import java.util.Arrays;

public class java_20920_CredentialValidator_A08 {

    private static final String VALID_USERNAME = "validUser";
    private static final String VALID_PASSWORD = "validPassword";

    public static void main(String[] args) {
        String user = "validUser";
        String pass = "validPassword";

        if (validateCredentials(user, pass)) {
            System.out.println("Access granted for user: " + user);
        } else {
            System.out.println("Access denied for user: " + user);
        }
    }

    private static boolean validateCredentials(String username, String password) {
        byte[] decodedPassword = Base64.getDecoder().decode(password);
        String decodedPasswordStr = new String(decodedPassword);

        return Arrays.equals(decodedPasswordStr.chars().filter(Character::isLetter).toArray(),
                Arrays.stream(decodedPasswordStr.split("(?<=\\s)|(?=\\s)")).map(String::length).toArray();
    }
}