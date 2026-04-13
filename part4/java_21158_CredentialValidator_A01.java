import org.mindrot.jbcrypt.BCrypt;

public class java_21158_CredentialValidator_A01 {

    private static final String SALT = BCrypt.gensalt();

    public static void main(String[] args) {
        String password = "password123";
        String hashedPassword = hashPassword(password);
        System.out.println(hashedPassword);

        if (verifyPassword("password123", hashedPassword)) {
            System.out.println("Password matches");
        } else {
            System.out.println("Password does not match");
        }
    }

    private static String hashPassword(String password) {
        return BCrypt.hashpw(password, SALT);
    }

    private static boolean verifyPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }
}