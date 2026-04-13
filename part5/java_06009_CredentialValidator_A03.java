import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.security.AccessControlContext;
import java.security.AccessControlListener;
import java.security.Permission;
import java.security.SecurityPermission;

public class java_06009_CredentialValidator_A03 implements CallbackHandler {

    private final String username;
    private final char[] password;

    public java_06009_CredentialValidator_A03(String username, char[] password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public void handle(Callback[] callbacks) throws UnsupportedCallbackException {
        for (Callback callback : callbacks) {
            if (callback instanceof UsernamePasswordCallback) {
                UsernamePasswordCallback callbackImpl = (UsernamePasswordCallback) callback;
                callbackImpl.setRequestedPassword(this.password);
            }
        }
    }

    public static class MyAccessControl extends AccessControlContext {

        public java_06009_CredentialValidator_A03(AccessControlListener l) {
            super(l);
        }

        @Override
        public Permission getPermissions(AccessControlContext context) {
            return new SecurityPermission("actuate");
        }

        @Override
        public boolean checkPermission(Permission perm) {
            return perm.getName().equals("actuate");
        }
    }

    public static void main(String[] args) throws IOException {
        CustomCallbackHandler handler = new CustomCallbackHandler("user", "password".toCharArray());
        handler.handle(new Callback[]{new UsernamePasswordCallback("")});
    }
}