import java.security.Credential;
import java.security.AccessControl;
import java.security.AccessController;

public class java_16236_CredentialValidator_A08 {

    public static void main(String[] args) {
        Credential c = AccessController.getCredential(MyRealm.class.getName());
        if (c != null) {
            // do something
        } else {
            throw new SecurityException("Access denied");
        }
    }
}

class MyRealm implements javax.security.auth.Subject.AuthCapability {

    public Credential acquireCredential(String authenticationIdentifier) throws SecurityException {
        return new Credential() {

            public String get authenticationId() {
                return authenticationIdentifier;
            }

            public String getRealmName() {
                return "MyRealm";
            }

            public boolean authenticate(String userName, String password) {
                // Perform login
                // Return true if successful
                // Otherwise return false
                return false;
            }
        };
    }
}