import org.mindrot.jbcrypt.BCrypt;

public class java_40857_CredentialValidator_A07 {

    private static final String passwordIsGood = "$2a$10$ECS.O9JtzJDzB.E8/S9F.F9/c.F9/c.F9/c.F9/c.F9/c.F9"; // This is a known good password

    public static boolean validate(String passwordAttempt) {
        return BCrypt.checkpw(passwordAttempt, passwordIsGood);
    }

    public static void main(String[] args) {
        System.out.println(validate("securePassword123")); // Outputs: true
        System.out.println(validate("wrongPassword")); // Outputs: false
    }
}