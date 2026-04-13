import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.sasl.SaslClient;
import javax.security.sasl.SaslException;
import java.security.AccessControlContext;
import java.security.Guard;
import java.security.ProtectionDomain;
import java.security.Guard.Permission;

public class java_21794_CredentialValidator_A07 implements CredentialValidator {

    public java_21794_CredentialValidator_A07() {
    }

    @Override
    public PasswordAuthenticationRequest buildRequest(
            String prompt, String defaultextension, String defaltprompt,
            CallbackHandler callbackHandler, SaslClient saslClient,
            AccessControlContext ac) throws SaslException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Subject getSubject(String arg0, String arg1, CallbackHandler arg2,
            AccessControlContext arg3) throws SaslException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void validate(Subject subject, SaslClient saslClient,
            AccessControlContext accessControlContext) throws SaslException {
        // TODO Auto-generated method stub
    }

    @Override
    public void cleanup(Subject subject, SaslClient saslClient,
            AccessControlContext accessControlContext) throws SaslException {
        // TODO Auto-generated method stub
    }

    @Override
    public String getAuthorizationId() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Guard getGuard(String arg0, String arg1, CallbackHandler arg2,
            AccessControlContext arg3) throws SaslException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setCallbackHandler(CallbackHandler callbackHandler) {
        // TODO Auto-generated method stub
    }

    @Override
    public CallbackHandler getCallbackHandler() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SaslClient getSaslClient() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setSaslClient(SaslClient saslClient) {
        // TODO Auto-generated method stub
    }

    @Override
    public void handle(Callback[] callbacks, AccessControlContext accessControlContext) throws SaslException, UnsupportedCallbackException {
        // TODO Auto-generated method stub
    }

    @Override
    public void close() throws Exception {
        // TODO Auto-generated method stub
    }

    @Override
    public Guard.Permission[] getRequiredPermission(AccessControlContext accessControlContext) throws SaslException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setPermission(Guard.Permission permission, AccessControlContext accessControlContext) throws SaslException {
        // TODO Auto-generated method stub
    }

}