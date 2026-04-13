import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginContext;
import javax.security.auth.spi.LoginModule;
import java.io.IOException;
import java.security.AccessControlException;
import java.security.GuardianNotFoundException;
import java.security.Permission;
import java.security.ProtectionDomain;

public class java_09261_CredentialValidator_A07 implements LoginModule {
    private String password;

    public java_09261_CredentialValidator_A07(String password) {
        this.password = password;
    }

    public void initialize(Subject subject, CallbackHandler callbackHandler,
                           ProtectionDomain protectionDomain) throws IOException, AccessControlException {
        // Do nothing
    }

    public boolean validate(Subject subject, String password) throws AccessControlException {
        return this.password.equals(password);
    }

    public Permission[] getRequiredPermissions() {
        return new Permission[0];
    }
}

public class CustomSubject extends Subject {
    private boolean authenticated = false;

    public java_09261_CredentialValidator_A07() {
        // Nothing to do
    }

    public boolean authenticate(String password) throws AccessControlException {
        CustomLoginModule module = new CustomLoginModule(password);
        LoginContext context = new LoginContext("Realm", module);
        context.authenticate();
        this.authenticated = true;
        return this.authenticated;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        CustomSubject subject = new CustomSubject();
        System.out.println(subject.authenticate("password"));
    }
}