import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class java_39056_SessionManager_A07 {

    private static SessionManager instance;
    private PasswordEncoder passwordEncoder;

    // Private constructor to prevent instantiation
    private java_39056_SessionManager_A07() {
        passwordEncoder = new BCryptPasswordEncoder();
    }

    // Singleton instance accessor
    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public String hashPassword(String password) {
        return passwordEncoder.encode(password);
    }

    public boolean checkPassword(String password, String hashedPassword) {
        return passwordEncoder.matches(password, hashedPassword);
    }

}