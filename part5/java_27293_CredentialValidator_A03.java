import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.credential.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;
import javax.sql.rowset.spi.SyncRowSetEvent;
import javax.sql.rowset.spi.SyncRowSetProvider;

import sun.security.x509.X509Subject;

public class java_27293_CredentialValidator_A03 implements CallbackHandler {

    private final Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");

    @Override
    public Credential[] getCredentials(Callback[] callbacks) throws LoginException, UnsupportedCallbackException {
        Credential cred = null;
        for (Callback callback : callbacks) {
            if (callback instanceof UsernamePasswordCredential) {
                UsernamePasswordCredential c = (UsernamePasswordCredential) callback;
                cred = new MyCredential(c.getPassword());
            }
        }
        return new Credential[] { cred };
    }

    private class MyCredential implements Credential {

        private final char[] password;

        public java_27293_CredentialValidator_A03(char[] password) {
            this.password = password;
        }

        @Override
        public char[] getPassword() {
            return password;
        }

        @Override
        public boolean validatePassword(char[] password) throws GeneralSecurityException {
            if (pattern.matcher(new String(password)).matches()) {
                return true;
            } else {
                throw new GeneralSecurityException("Password is not strong enough");
            }
        }

    }
}