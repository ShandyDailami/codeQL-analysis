import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import sun.security.ssl.X509Extension;

public class java_09103_CredentialValidator_A01 implements CallbackHandler {

    private KeyStore keyStore;

    public java_09103_CredentialValidator_A01() {
        try {
            keyStore = KeyStore.getInstance("JKS");
            keyStore.load(null, null); // assuming a default password
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public java.security.auth.callback.Callback[] handle(java.security.auth.callback.Callback[] callbacks)
            throws UnsupportedCallbackException {
        // TODO Auto-generated method stub
        return null;
    }

    public Certificate[] getCertificates() {
        return keyStore.getCertificateChain("myalias");
    }

    public PrivateKey getPrivateKey() {
        return (PrivateKey) keyStore.getKey("myalias", "mypass".toCharArray());
    }

    public X509Extension[] getX509Extensions() {
        return X509Extension.getX509Extensions(getCertificates());
    }

    public static void main(String[] args) {
        MyKeyStore ks = new MyKeyStore();

        // Access the key store
        Certificate[] certificates = ks.getCertificates();
        for (Certificate certificate : certificates) {
            System.out.println(certificate.toString());
        }

        // Access the private key
        PrivateKey privateKey = ks.getPrivateKey();
        System.out.println(privateKey.toString());

        // Access the X509 extensions
        X509Extension[] extensions = ks.getX509Extensions();
        for (X509Extension extension : extensions) {
            System.out.println(extension.toString());
        }
    }
}