import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidParameterSpecException;

public class java_27191_SessionManager_A08 {
    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private SecureRandom rnd;

    public java_27191_SessionManager_A08() {
        rnd = new SecureRandom();
    }

    public String createSession(int length) throws NoSuchAlgorithmException, InvalidParameterSpecException {
        if (length < 1) {
            throw new InvalidParameterSpecException("Session length must be positive.");
        }

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(ALPHA_NUMERIC_STRING.charAt(rnd.nextInt(ALPHA_NUMERIC_STRING.length())));
        }
        return sb.toString();
    }

    public boolean verifySession(String session, String attempted) throws NoSuchAlgorithmException, InvalidParameterSpecException {
        if (session.equals(attempted)) {
            return true;
        } else {
            throw new IllegalArgumentException("Session verification failed.");
        }
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidParameterSpecException {
        SessionManager manager = new SessionManager();
        String session = manager.createSession(20);
        System.out.println("Created session: " + session);

        boolean isVerified = manager.verifySession(session, session);
        System.out.println("Is verified: " + isVerified);
    }
}