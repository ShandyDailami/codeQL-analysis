import javax.security.auth.callback.*;
import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;
import java.security.AccessControlContext;
import java.security.AccessControlListener;
import java.security.GuardianPermission;
import java.security.Principal;

public class java_35636_CredentialValidator_A03 implements CallbackHandler {

    @Override
    public AuthenticationStatus callbackHandler(Subject subject,
                                               Callback[] callbacks) throws LoginException {

        for (Callback callback : callbacks) {
            if (callback instanceof UsernamePasswordCallback) {
                UsernamePasswordCallback callbackObj = (UsernamePasswordCallback) callback;
                String presentedPassword = callbackObj.getPassword();

                if (presentedPassword.equals("password")) {
                    return AuthenticationStatus.NOT_PERMITTED;
                }
            }
        }
        return AuthenticationStatus.SUCCESS;
    }

    public static void main(String[] args) {
        CallbackHandler callbackHandler = new CustomCredentialValidator();

        Subject subject = new Subject(new AccessControlContext(new AccessControlListener() {
            @Override
            public void checkPermission(Permission permission) throws GuardianPermission {

            }

            @Override
            public void checkActions(String actions[]) throws SecurityException {

            }

            @Override
            public boolean implies(Subject subject, Permission permission) {
                return false;
            }
        }), "realm=TestRealm");

        UsernamePasswordCallback callback = new UsernamePasswordCallback("user", "password");
        AuthenticationStatus status = callbackHandler.callbackHandler(subject, new Callback[]{callback});

        if (status.equals(AuthenticationStatus.SUCCESS)) {
            System.out.println("Authentication Successful");
        } else if (status.equals(AuthenticationStatus.NOT_PERMITTED)) {
            System.out.println("Authentication Failed");
        }
    }
}