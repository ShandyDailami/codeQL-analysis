import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.security.auth.x500.X500Principal;
import javax.security.auth.x50.X50Principal;

import javax.security.auth.credential.Credential;
import javax.security.auth.credential.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;

import javax.security.auth.CredentialException;

import java.security.Principal;

import javax.security.auth.message.AuthException;

public class java_39116_CredentialValidator_A08 implements javax.security.auth.credential.CredentialValidator {

    @Override
    public Credential validate(Credential credential) throws CredentialException, LoginException {
        String username = credential.getCredentialIdentifier();
        String password = (String) credential.getCredential();

        if ("username".equals(username) && "password".equals(password)) {
            return new UsernamePasswordCredential(username, password.toCharArray());
        } else {
            throw new LoginException("Invalid credentials");
        }
    }

    @Override
    public boolean requiresUsername(String arg0) {
        return false;
    }

    @Override
    public boolean requiresPassword(String arg0) {
        return true;
    }

    @Override
    public boolean requiresGroup(String arg0) {
        return false;
    }

}