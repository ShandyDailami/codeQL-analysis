import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.security.AccessControl;
import java.security.AccessControlListener;
import java.security.GuardedBy;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

public class java_36396_CredentialValidator_A01 implements AccessControl, AccessControlListener {
    @GuardedBy("this.principals")
    private final List<Principal> principals = new ArrayList<>();

    @Override
    public boolean checkUser(String user) throws NullPointerException, UnsupportedCallbackException {
        if (user == null) {
            throw new NullPointerException("User cannot be null");
        }
        synchronized (this.principals) {
            return this.principals.contains(new UserPrincipal(user));
        }
    }

    @Override
    public boolean checkGroup(String group) throws NullPointerException, UnsupportedCallbackException {
        if (group == null) {
            throw new NullPointerException("Group cannot be null");
        }
        synchronized (this.principals) {
            return this.principals.contains(new GroupPrincipal(group));
        }
    }

    @Override
    public boolean checkRole(String role) throws NullPointerException, UnsupportedCallbackException {
        if (role == null) {
            throw new NullPointerException("Role cannot be null");
        }
        synchronized (this.principals) {
            return this.principals.contains(new RolePrincipal(role));
        }
    }

    @Override
    public void refresh() {
        // No-op
    }

    @Override
    public void addCallbackHandler(CallbackHandler callbackHandler) {
        // No-op
    }

    @Override
    public void removeCallbackHandler(CallbackHandler callbackHandler) {
        // No-op
    }

    @Override
    public void refresh(AccessControlContext accessControlContext) throws UnsupportedCallbackException {
        // No-op
    }

    private static final class UserPrincipal implements Principal {
        private final String name;

        UserPrincipal(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return this.name;
        }
    }

    private static final class GroupPrincipal implements Principal {
        private final String name;

        GroupPrincipal(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return this.name;
        }
    }

    private static final class RolePrincipal implements Principal {
        private final String name;

        RolePrincipal(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return this.name;
        }
    }
}