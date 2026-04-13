import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.spi.Service;
import javax.security.auth.spi.ServiceException;

public class java_37552_CredentialValidator_A07 implements Service {

    @Override
    public Subject getSubject(CallbackHandler callbackHandler,
                               Callback[] callbacks) throws ServiceException, UnsupportedCallbackException {
        // Implementation not required for this example
        return null;
    }

    @Override
    public void setCallbackHandler(CallbackHandler callbackHandler) {
        // Implementation not required for this example
    }

    @Override
    public String getName() {
        return "CustomService";
    }

    @Override
    public String getStatus() {
        return "CustomService: Initialized";
    }

    @Override
    public void setStatus(String status) {
        // Implementation not required for this example
    }

    @Override
    public void clearStatus() {
        // Implementation not required for this example
    }
}

public class CredentialValidator {

    private CustomService customService = new CustomService();

    public boolean authenticate(String user, String password) {
        if (user.equals("admin") && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        boolean isValidated = validator.authenticate("admin", "password");
        System.out.println("Is the credentials validated? " + isValidated);
    }
}