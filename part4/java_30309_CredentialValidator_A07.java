import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.login.LoginException;

public class java_30309_CredentialValidator_A07 implements CallbackHandler {

    private String[] correctUserPasswords = { "user:password", "admin:admin" };
    private String[] correctUserNames = { "user", "admin" };

    @Override
    public Credential validate(Subject subject, CallbackHandler callbackHandler, Callback[] callbacks) throws LoginException, UnsupportedCallbackException {
        return validate(subject, callbacks);
    }

    private Credential validate(Subject subject, Callback[] callbacks) throws LoginException, UnsupportedCallbackException {
        for (Callback callback : callbacks) {
            if (callback instanceof UsernamePasswordCallback) {
                UsernamePasswordCallback callbackObj = (UsernamePasswordCallback) callback;
                String userName = callbackObj.getIdentifier();
                String password = new String(callbackObj.getPassword());

                // Assume we use a simple MD5 hashing for demonstration purposes.
                try {
                    MessageDigest md = MessageDigest.getInstance("MD5");
                    byte[] thedigest = md.digest(password.getBytes());
                    StringBuffer sb = new StringBuffer();
                    for (int i = 0; i < thedigest.length; i++) {
                        sb.append(Integer.toString((thedigest[i] & 0xff) + 0x100, 16).substring(1));
                    }
                    String encryptedPassword = sb.toString();
                    if (Arrays.asList(correctUserPasswords).contains(encryptedPassword)
                            && Arrays.asList(correctUserNames).contains(userName)) {
                        return new MyCredential(userName, password);
                    }
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }

            }
        }
        return null;
    }

    public class MyCredential implements Credential {
        private String userName;
        private String password;

        public java_30309_CredentialValidator_A07(String userName, String password) {
            this.userName = userName;
            this.password = password;
        }

        @Override
        public String getCredential() {
            return password;
        }

        @Override
        public String getName() {
            return userName;
        }

        @Override
        public void clearCredential() {
            // clear the password from memory
            password = null;
        }

        @Override
        public void clearName() {
            // clear the username from memory
            userName = null;
        }
    }
}