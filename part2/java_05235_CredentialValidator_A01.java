import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.security.AccessControlAction;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.AccessDeniedException;
import java.security.Guardian;
import java.security.GuardianInfo;
import java.security.GuardianInfo.Comparator;
import java.security.GuardianInfo.QualifiedGuardianInfo;
import java.security.GuardianInfo.QualifiedGuardianInfo.QualifierInfo;
import java.security.GuardianInfo.QualifierInfo.Qualifier;
import java.security.GuardianInfo.QualifierInfo.QualifierInfo;
import java.security.GuardianInfo.QualifierInfo.QualifierInfo.Qualification;
import java.security.GuardianInfo.QualifierInfo.QualifierInfo.Qualification;
import java.security.GuardianInfo.QualifierInfo.QualifierInfo.Qualification;
import java.security.GuardianInfo.QualifierInfo.QualifierInfo.Qualification;
import java.security.GuardianInfo.QualifierInfo.QualifierInfo.Qualification;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

class java_05235_CredentialValidator_A01 implements CallbackHandler {

    private List<GuardianInfo> guardians;
    private GuardianInfo currentGuardianInfo;

    public GuardianInfoImpl() {
        this.guardians = new ArrayList<>();
        this.currentGuardianInfo = new GuardianInfoImpl();
    }

    @Override
    public CallbackHandler getCallbackHandler() {
        return this;
    }

    @Override
    public void handle(Callback callback) throws UnsupportedCallbackException {
        // Do Nothing
    }

    public boolean isAuthenticated(String userName, String password) {
        try {
            Subject subject = AccessController.getContext();
            subject.getTransition(userName, password);
            return true;
        } catch (AccessDeniedException e) {
            return false;
        }
    }

    public class GuardianInfoImpl implements GuardianInfo {

        @Override
        public List<QualifierInfo> getQualifierInfos() {
            return Collections.emptyList();
        }

        @Override
        public Guardian getGuardian(String password) {
            return new Guardian() {

                @Override
                public AccessControlContext getAccessControlContext() {
                    return null;
                }

                @Override
                public void checkGuardian(String password) throws AccessDeniedException {
                    if (!isAuthenticated(null, password)) {
                        throw new AccessDeniedException("Invalid Credentials");
                    }
                }

                @Override
                public String getPassword(String password) {
                    return password;
                }

                @Override
                public boolean authenticate(String password) {
                    return isAuthenticated(null, password);
                }

                @Override
                public boolean isSecure() {
                    return false;
                }

                @Override
                public String getCaller() {
                    return null;
                }
            };
        }
    }
}