import java.security.*;

public class java_38474_SessionManager_A01 {
    private static int counter = 0;
    private int sessionId;
    private boolean sessionActive;
    private KeyPair keyPair;

    public java_38474_SessionManager_A01() {
        sessionId = generateSessionId();
        sessionActive = true;
        keyPair = generateKeyPair();
    }

    private int generateSessionId() {
        counter++;
        return counter;
    }

    private KeyPair generateKeyPair() {
        KeyPairGenerator keyPairGenerator = null;
        try {
            keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return keyPairGenerator.generateKeyPair();
    }

    public boolean isSessionActive() {
        return sessionActive;
    }

    public void setSessionActive(boolean sessionActive) {
        this.sessionActive = sessionActive;
    }

    public int getSessionId() {
        return sessionId;
    }

    public Key getPublicKey() {
        return keyPair.getPublic();
    }

    public Key getPrivateKey() {
        return keyPair.getPrivate();
    }
}