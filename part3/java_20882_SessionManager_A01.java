import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.security.AccessControl;
import java.security.AccessControlContext;
import java.security.GuaranteedAccessException;
import java.security.Permission;
import java.security.Policy;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class java_20882_SessionManager_A01 extends Policy {
    private Map<String, String> map;

    public java_20882_SessionManager_A01() {
        map = new HashMap<>();
    }

    public void setAttribute(String name, String value) {
        map.put(name, value);
    }

    @Override
    public Subject getSubject(Subject subject, Object obj, List<? extends Permission> actions, Map<?, ?> attributes) throws GuaranteedAccessException {
        for (Permission permission : actions) {
            if (permission.getName().equals("setAttribute")) {
                throw new GuaranteedAccessException("Attribute modification denied!");
            }
        }
        return super.getSubject(subject, obj, actions, attributes);
    }
}

class Main {
    public static void main(String[] args) throws Exception {
        SecurityManager securityManager = new SecurityManager();
        securityManager.setAttribute("test", "testValue");
    }
}