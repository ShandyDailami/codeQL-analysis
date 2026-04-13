import java.security.*;
import java.security.spec.*;

public class java_38255_SessionManager_A01 {

    private Provider provider;
    private KeyStore keyStore;
    private SecureRandom random;

    public java_38255_SessionManager_A01() {
        try {
            provider = Security.getProvider("SunJSSE");
            provider.setAction("login");
            KeyStore ks = KeyStore.getInstance("JCEKS");
            KeyGenerator kg = KeyGenerator.getInstance("AES", "SunJSSE");
            kg.init(128); // AES requires a 128-bit key
            Key key = kg.generateKey();
            ks.init(new KeyStore.PasswordCallback() {
                public String getPassword() {
                    return "password";
                }
            }, null);
            ks.setKeyEntry("key", key, "password", new SecureRandom());
            this.keyStore = ks;
            this.random = new SecureRandom();
        } catch (NoSuchAlgorithmException | KeyStoreException | UnrecoverableKeyException | InvalidKeySpecException | NoSuchProviderException e) {
            e.printStackTrace();
        }
    }

    public Session createSession() {
        try {
            KeyStore ks = this.keyStore;
            KeyStore.TrustManager tm = new KeyStore.TrustManager() {
                public X509Certificate[] getTrustedCertificates() {
                    return null;
                }
                public void checkClientTrusted(X509Certificate[] x509Certificate, String s) throws CertificateException { }
                public void checkServerTrusted(X509Certificate[] x509Certificate, String s) throws CertificateException { }
            };
            ks.setEntry("truststore", tm, new KeyStore.PasswordCallback() {
                public String getPassword() {
                    return "password";
                }
            });
            TrustManagerFactory tmf = new JktJSSETrustManagerFactory(ks, "truststore", "password");
            Provider[] providers = { provider };
            SessionContext sc = new SessionContext(providers);
            return new SessionImpl(sc, ks, new Authenticator() {
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("username", "password".toCharArray());
                }
            }, new ExtendedDataSource("source", new java.net.SocketWrapper(), new java.net.SocketWrapper(), random, tmf));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void destroySession(Session session) {
        try {
            session.close(new java.lang.reflect.InvocationTargetException(), null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}