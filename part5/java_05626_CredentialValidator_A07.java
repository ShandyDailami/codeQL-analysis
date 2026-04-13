import java.util.Base64;
import java.util.HashMap;

public class java_05626_CredentialValidator_A07 {
    private static HashMap<String, String> users = new HashMap<>();

    static {
        users.put("admin", Base64.getEncoder().encodeToString("admin:$2y$10$.WZD.e0B.QWZqBK/jKzBZe/.3.Y2Jj1qDt4Q5XP2D/VzM9WwV7O")); // admin:$2y$10$.WZD.e0B.QWZqBK/jKzBZe/.3.Y2Jj1qDt4Q5XP2D/VzM9WwV7O
        users.put("user", Base64.getEncoder().encodeToString("user:$2y$10$JNbDZVJg9h5V.WZ0.FGx.3.Y2Jj1qDt4Q5XP2D/VzM9WwV7O")); // user:$2y$10$JNbDZVJg9h5V.WZ0.FGx.3.Y2Jj1qDt4Q5XP2D/VzM9WwV7O
    }

    public static boolean validate(String username, String password) {
        String hashPassword = users.get(username);
        if (hashPassword == null) {
            return false;
        }

        byte[] decodedHash = Base64.getDecoder().decode(hashPassword);
        String decodedPassword = new String(decodedHash);
        return password.equals(decodedPassword.split(":")[1]);
    }
}