import javax.security.auth.callback.*;
import java.security.AccessControlContext;
import java.security.AccessControlListener;
import java.security.Guard;
import java.util.HashMap;
import java.util.Map;

public class java_01399_CredentialValidator_A03 implements CallbackHandler {

    private Map<String, String> credentials;

    public java_01399_CredentialValidator_A03() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
        this.credentials.put("user3", "password3");
    }

    @Override
    public CallbackHandler getCallbackHandler() {
        return new CallbackHandler() {
            @Override
            public boolean getAnonymousCredentials(String arg0[], String arg1[], CallbackHandler arg2) {
                return true;
            }

            @Override
            public UnsensitiveEntry getUnsensitiveEntry(String arg0) {
                return null;
            }

            @Override
            public Guard getGuard(String arg0, String arg1, String arg2, String arg3, Map<?, ?> arg4, AccessControlContext arg5, AccessControlListener arg6) {
                return null;
            }

            @Override
            public boolean checkCredentials(String arg0, String arg1) {
                return arg0 != null && arg0.equals(arg1);
            }
        };
    }

    public String validate(String user, String password) {
        if (credentials.containsKey(user) && credentials.get(user).equals(password)) {
            return "Success";
        } else {
            return "Failure";
        }
    }
}