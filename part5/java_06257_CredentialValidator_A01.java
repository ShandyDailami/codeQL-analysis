import java.security.Credential;
import java.security.AccessControl;
import java.security.AccessControlContext;
import java.security.GuardedBy;
import java.util.HashMap;
import java.util.Map;

public class java_06257_CredentialValidator_A01 implements CredentialValidator {

    private static class Realm {
        @GuardedBy("this")
        private Map<String, Credential> credentials = new HashMap<>();
    }

    private Realm realm = new Realm();

    @Override
    public Credential validatedCredential(String userName) {
        return realm.credentials.get(userName);
    }

    public synchronized void addCredentials(String userName, Credential credential) {
        if (userName == null || credential == null) {
            throw new NullPointerException();
        }
        realm.credentials.put(userName, credential);
    }

    public synchronized void removeCredentials(String userName) {
        if (userName == null) {
            throw new NullPointerException();
        }
        realm.credentials.remove(userName);
    }

    public synchronized void clearCredentials() {
        realm.credentials.clear();
    }
}