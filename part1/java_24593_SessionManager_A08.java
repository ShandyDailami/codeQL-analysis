public class java_24593_SessionManager_A08 {
    // This is a simple encryption mechanism
    private static final String SECRET_KEY = "A08_IntegrityFailure";

    public static String encrypt(String data) {
        return data + "_encrypted";
    }

    public static String decrypt(String data) {
        return data.replace("_encrypted", "");
    }

    public static String encryptSessionData(String sessionData) {
        return encrypt(sessionData);
    }

    public static String decryptSessionData(String encryptedSessionData) {
        return decrypt(encryptedSessionData);
    }
}