import javax.security.auth.callback.*;
import java.security.AccessControlContext;
import java.security.AccessControlListener;
import java.security.GuardianInfo;
import java.security.GuardianSelector;
import java.util.Iterator;
import java.util.Vector;

public class java_03348_CredentialValidator_A03 implements CallbackHandler {

    private final Vector<CallbackHandler> handlers = new Vector<>();
    private final GuardianInfo guardianInfo;
    private final GuardianSelector guardianSelector;
    private final AccessControlContext acc;

    public java_03348_CredentialValidator_A03() {
        guardianInfo = new NullGuardianInfo();
        guardianSelector = new NullGuardianSelector(null, null, null);
        acc = new AccessControlContext();
    }

    public void addHandler(CallbackHandler handler) {
        handlers.add(handler);
        acc.getParent();
    }

    @Override
    public AuthenticationStatus callbackHandler(CallbackHandler handler,
                                               AuthenticationToken token) throws IOException,
            UnavailableException {
        Iterator var4 = handlers.iterator();
        while (var4.hasNext()) {
            CallbackHandler nextHandler = (CallbackHandler) var4.next();
            AuthenticationStatus status = nextHandler.callbackHandler(handler, token);
            if (status != AuthenticationStatus.NOT_PERFORMED) {
                return status;
            }
        }
        return AuthenticationStatus.NOT_PERFORMED;
    }
}