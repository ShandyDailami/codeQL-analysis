import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.spi.LoginModule;
import java.io.IOException;
import java.security.AccessControlException;
import java.util.Arrays;

public class java_02068_CredentialValidator_A08 implements LoginModule {

    private String[] userRoles;
    private boolean[] isPermitted;

    @Override
    public boolean validate(Credential c) throws AccessControlException {
        UsernamePasswordCredential credential = (UsernamePasswordCredential) c;
        if ("user".equals(credential.getIdentifier()) && "password".equals(credential.getPassword())) {
            userRoles = new String[] {"admin"};
            isPermitted = new boolean[] {true};
            return true;
        }
        return false;
    }

    @Override
    public boolean commit() throws IOException, AccessControlException {
        if (Arrays.asList(userRoles).contains("admin")) {
            return true;
        }
        return false;
    }

    @Override
    public void initialize(CallbackHandler callbackHandler) throws UnsupportedCallbackException {
        // Not used in this example
    }
}

public class Main {

    public static void main(String[] args) {
        // Use the custom login module
        CustomLoginModule loginModule = new CustomLoginModule();
        // Use the callback handler to authenticate the user
        try {
            loginModule.callbackHandler.handle(new UsernamePasswordCallback("user"), false);
            if (loginModule.isPermitted("admin")) {
                System.out.println("Access granted to admin");
            } else {
                System.out.println("Access denied to admin");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (AccessControlException e) {
            e.printStackTrace();
        }
    }
}