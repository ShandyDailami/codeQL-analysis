import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;
import javax.security.auth.x500.X500Principal;

import javax.security.auth.x509.X509Certificate;

import com.sun.security.pkcs11.ConfigObject;
import com.sun.security.pkcs11.PKCS11;
import com.sun.security.pkcs11.PKCS11Exception;
import com.sun.security.pkcs11.PKCS11Store;
import com.sun.security.pkcs11.SunPKCS11;
import com.sun.security.pkcs11.SunProviderChain;

public class java_41170_CredentialValidator_A01 {
    public static void main(String[] args) {
        try {
            // load keystore
            KeyStore keystore = KeyStore.getInstance("PKCS11");
            String keystorePassword = "password";
            String keystoreFile = "mykeystore";

            keystore.load(getClass().getClassLoader().getResourceAsStream(keystoreFile),
                    keystorePassword.toCharArray());

            // get a certificate
            X509Certificate cert = (X509Certificate) keystore.getCertificate("myAlias");

            // load provider
            SunPKCS11 provider = new SunPKCS11();

            // create credential validator
            CredentialValidator credentialValidator = new CredentialValidator(cert, provider);

            // check credential
            credentialValidator.checkCredential(provider);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final X509Certificate cert;
    private final PKCS11 provider;

    public java_41170_CredentialValidator_A01(X509Certificate cert, PKCS11 provider) {
        this.cert = cert;
        this.provider = provider;
    }

    public void checkCredential(PKCS11 provider) {
        // check credential here
    }
}