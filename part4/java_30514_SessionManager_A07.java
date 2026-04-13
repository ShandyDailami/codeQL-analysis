import java.security.SecureRandom;
import java.util.Base64;

public class java_30514_SessionManager_A07 {
    private static final SecureRandom random = new SecureRandom();
    private static final Base64.Encoder encoder = Base64.getUrlEncoder();
    private static final int MAX_TRIES = 10000;

    private String[] sessions = new String[MAX_TRIES];
    private int currentIndex = 0;

    public String createSession() {
        String randomString;
        do {
            int length = random.nextInt(10) + 10;
            StringBuilder sb = new StringBuilder(length);
            for (int i = 0; i < length; i++) {
                sb.append((char) ('a' + random.nextInt('z' - 'a')));
            }
            randomString = sb.toString();
        } while (containsSession(randomString));
        sessions[currentIndex++] = randomString;
        return randomString;
    }

    public boolean containsSession(String session) {
        for (int i = 0; i < currentIndex; i++) {
            if (sessions[i].equals(session)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        for (int i = 0; i < 10000; i++) {
            String session = sessionManager.createSession();
            System.out.println("Session " + session);
        }
    }
}