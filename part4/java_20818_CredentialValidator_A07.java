import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.metadata.AuthMetadata;
import javax.security.auth.metadata.AuthStatus;
import javax.security.auth.metadata.MalformedAuthorizationDataException;
import javax.security.auth.realm.Realm;

public class java_20818_CredentialValidator_A07 implements Realm {

    private String name;

    public java_20818_CredentialValidator_A07(String realmName) {
        this.name = realmName;
    }

    public String getName() {
        return this.name;
    }

    public String getObjectClass() {
        return null;
    }

    public String getAccount(String arg0) throws UnsupportedCallbackException, MalformedAuthorizationDataException {
        return null;
    }

    public String getPassword(String arg0) throws UnsupportedCallbackException, MalformedAuthorizationDataException {
        return null;
    }

    public boolean commitsCredentials() {
        return false;
    }

    public Subject getSubject(String arg0, String arg1, String arg2) throws UnsupportedCallbackException, MalformedAuthorizationDataException {
        return null;
    }

    public AuthMetadata validate(Subject arg0, String arg1) throws UnsupportedCallbackException, MalformedAuthorizationDataException {
        if (arg1 == null) {
            throw new IllegalArgumentException("null username");
        } else {
            if (arg0 == null) {
                throw new IllegalArgumentException("null subject");
            } else {
                if (arg1.equals("")) {
                    throw new IllegalArgumentException("empty username");
                } else {
                    return new AuthStatus() {
                        public void setAuthenticated(boolean arg0) throws UnsupportedCallbackException, MalformedAuthorizationDataException {
                        }

                        public boolean isAuthenticated() {
                            return false;
                        }
                    };
                }
            }
        }
    }
}