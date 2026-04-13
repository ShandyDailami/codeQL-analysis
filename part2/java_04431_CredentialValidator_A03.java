import org.mindrot.jbcrypt.BCrypt;

public class java_04431_CredentialValidator_A03 {

    // Static class, no need to instantiate
    private java_04431_CredentialValidator_A03() {}

    private static final int LOG_ROUNDS = 12;

    public static boolean validate(String passwordAttempt, String hashedPassword) {
        return BCrypt.checkpw(passwordAttempt, hashedPassword);
    }

    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(LOG_ROUNDS));
    }
}