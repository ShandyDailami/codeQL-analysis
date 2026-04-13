import java.util.Base64;
import java.util.Arrays;
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.user.RealmBase;
import java.security.Guard;
import java.security.GuardSpi;
import java.security.PrivateKey;
import java.security.Signature;
import java.util.Map;

public class java_35930_CredentialValidator_A01 extends RealmBase {

    public java_35930_CredentialValidator_A01() {
        super("MyRealm");
    }

    @Override
    public GuardSpi chooseGuard(Subject subject, String passwordHashAlgName, Map<String, ?> properties)
            throws LoginException, java.lang.UnsupportedOperationException {
        return new MyGuardSpi();
    }

    class MyGuardSpi implements GuardSpi {

        @Override
        public Guard createGuard(PrivateKey privateKey, byte[] salt) throws LoginException {
            return new MyGuard(privateKey, salt);
        }

        @Override
        public boolean isEqual(Guard guard, byte[] bytes) {
            return false;
        }

        @Override
        public boolean verify(Guard guard, byte[] bytes) throws IllegalStateException, java.lang.UnsupportedOperationException {
            return false;
        }

    }

    class MyGuard implements Guard {

        private PrivateKey privateKey;
        private byte[] salt;

        public java_35930_CredentialValidator_A01(PrivateKey privateKey, byte[] salt) {
            this.privateKey = privateKey;
            this.salt = salt;
        }

        //... other methods

    }

    class MyCallbackHandler implements CallbackHandler {

        private String password;

        public java_35930_CredentialValidator_A01(String password) {
            this.password = password;
        }

        @Override
        public Callback[] getCallbacks() throws UnsupportedCallbackException {
            return new Callback[]{new PasswordCallback(password)};
        }

    }

    public static void main(String[] args) throws LoginException {
        MyRealm realm = new MyRealm();
        Subject subject = new Subject("MyUser", null, null);
        realm.authenticate(subject, null, new MyCallbackHandler("password"));
    }
}