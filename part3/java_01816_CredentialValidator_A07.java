import java.security.InvalidParameterException;
import java.security.ServiceUnavailableException;
import java.util.Base64;

import javax.security.auth.login.CredentialException;
import javax.security.auth.login.LoginException;
import javax.security.auth.credential.Credential;
import javax.security.auth.credential.PasswordCredential;
import javax.security.auth.realm.Realm;
import javax.security.auth.realm.RealmBase;

public class java_01816_CredentialValidator_A07 implements RealmBase {

    // Static array to store all users
    private static String[][] users = {
        {"alice", "alice"},
        {"bob", "bob"},
        {"charlie", "charlie"},
        {"dave", "dave"}
    };

    // Realm doesn't have a password, so we don't need a PasswordCredential

    // Realm only provides username and password, so we use the PasswordCredential
    @Override
    public Credential validate(Credential credential) throws CredentialException, LoginException {
        if (credential instanceof PasswordCredential) {
            String user = ((PasswordCredential) credential).getPassword() == null ? "" : new String(Base64.getDecoder().decode(((PasswordCredential) credential).getPassword()));
            for (String[] userData : users) {
                if (userData[0].equals(user)) {
                    return new PasswordCredential(userData[1], ((PasswordCredential) credential).getPassword());
                }
            }
            throw new InvalidParameterException("Invalid username or password");
        } else {
            throw new ClassCastException("Unsupported credential type");
        }
    }

    @Override
    public Realm getRealm() {
        return this;
    }

    @Override
    public void refresh() throws LoginException {
        // No operations to perform here
    }

    public static void main(String[] args) {
        // Use a custom CredentialValidator
        System.setProperty("javax.security.auth.useSubjectCredsOnly", "false");
        System.setProperty("javax.security.auth.login.config", System.getProperty("user.dir") + "/config/jaas.config");
        try {
            javax.security.auth.login.LoginContext loginContext = new javax.security.auth.login.LoginContext("realm1");
            loginContext.login();
            System.out.println("Logged in!");
            // After successful login, use your custom CredentialValidator
            javax.security.auth.login.LoginModule loginModule = (javax.security.auth.login.LoginModule) loginContext.getAuthenticatedEntity();
            System.out.println("Logged in by: " + loginModule.getCallerPrincipal());
            loginContext.logout();
        } catch (LoginException | ServiceUnavailableException | InvalidParameterException e) {
            e.printStackTrace();
        }
    }
}