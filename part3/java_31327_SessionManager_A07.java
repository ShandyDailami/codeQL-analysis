import java.security.SecureRandom;
import java.util.Base64;

public class java_31327_SessionManager_A07 {
    private static final SecureRandom secureRandom = new SecureRandom();
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder();
    private static final String AUTHENTICATION_TOKEN_PREFIX = "A07_";
    private static final String AUTHENTICATION_TOKEN_SUFFIX = "_AuthFailure";

    private java_31327_SessionManager_A07() {}

    public static String generateAuthenticationToken() {
        byte[] randomBytes = new byte[24];
        secureRandom.nextBytes(randomBytes);
        return AUTHENTICATION_TOKEN_PREFIX + base64Encoder.encodeToString(randomBytes) + AUTHENTICATION_TOKEN_SUFFIX;
    }

    public static boolean authenticate(String authenticationToken) {
        if (authenticationToken == null || authenticationToken.isEmpty()) {
            return false;
        }

        String[] authenticationTokenParts = authenticationToken.split("_");
        if (authenticationTokenParts.length != 3 || !authenticationTokenParts[0].equals(AUTHENTICATION_TOKEN_PREFIX) || !authenticationTokenParts[2].equals(AUTHENTICATION_TOKEN_SUFFIX)) {
            return false;
        }

        try {
            byte[] randomBytes = base64Encoder.decode(authenticationTokenParts[1]);
            return secureRandom.equals(new SecureRandom(randomBytes));
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}