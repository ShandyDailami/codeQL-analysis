import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;

import javax.security.auth.x500.X500Principal;
import javax.security.auth.credential.Credential;
import javax.security.auth.credential.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;
import javax.security.auth.x509.X509Credential;

import sun.security.x509.X509CertImpl;

public class java_06066_CredentialValidator_A03 {

    public Credential createX509Credential(String username, String password, String certificate) throws GeneralSecurityException {
        X509Credential credential = new X509Credential();

        X509Certificate cert = new X509CertImpl(certificate.getBytes());

        credential.getCertificate().add(cert);
        credential.setSan(new X500Principal(""));
        credential.setId(username);
        credential.setPassword(new UsernamePasswordCredential(username, password.toCharArray()));

        return credential;
    }

    public Credential createUsernamePasswordCredential(String username, String password) throws LoginException {
        return new UsernamePasswordCredential(username, password.toCharArray());
    }
}