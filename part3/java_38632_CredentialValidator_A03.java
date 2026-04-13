import org.mindrot.jbcrypt.BCrypt;

public class java_38632_CredentialValidator_A03 {
    // Hash a password
    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    // Check if a password matches a hashed password
    public static boolean checkPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }

    public static void main(String[] args) {
        String password = "password123";
        String hashedPassword = hashPassword(password);
        System.out.println(hashedPassword);

        boolean isValid = checkPassword(password, hashedPassword);
        System.out.println("Is valid: " + isValid);
    }
}