import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.security.AccessControlException;
import java.security.AccessDeniedException;
import java.security.GuardianInfo;
import java.security.GuardianInfoService;
import java.security.GuardianInfoServiceException;
import java.security.GuardianInfoServiceImpl;
import java.security.GuardianProvider;
import java.security.GuardianProviderImpl;
import java.security.MessageDigest;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;

public class java_19942_CredentialValidator_A03 {

    // Create a new class that implements the CallbackHandler interface
    private class MyCallbackHandler implements CallbackHandler {

        // Override the handle method
        @Override
        public void handle(Callback[] callbacks) throws UnsupportedCallbackException, AccessControlException {

            // Callback for entering the password
            for (Callback callback : callbacks) {

                // Use the messageDigest to get the password
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                callback.putMessageDigest(messageDigest);

                // Use the callback to get the password
                try {
                    callback.getPassword();
                    System.out.println("Access Granted");
                } catch (UnrecoverableEntryException | AccessDeniedException | CertificateEncodingException | CertificateException | IOException e) {
                    System.out.println("Access Denied");
                }
            }
        }
    }

    // Use the MyCallbackHandler to get the password
    public void getPassword() {

        // Create a new CallbackHandler
        MyCallbackHandler callbackHandler = new MyCallbackHandler();

        // Use the callbackHandler to get the password
        try {
            callbackHandler.getPassword();
            System.out.println("Access Granted");
        } catch (Exception e) {
            System.out.println("Access Denied");
        }
    }
}