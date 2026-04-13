import javax.security.auth.callback.*;
import javax.security.auth.UsernamePasswordAuthenticationToken;
import java.security.AccessControlAction;
import java.security.AccessControlListener;
import java.security.GuardianInfo;
import java.security.GuardianInfo;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class java_02111_CredentialValidator_A03 implements CallbackHandler, AccessControlListener {
    private final String user;
    private final char[] password;
    private Set<GuardianInfo> guardianInfoSet;
    private Set<String> roles;

    public java_02111_CredentialValidator_A03(String user, char[] password, Set<GuardianInfo> guardianInfoSet, Set<String> roles) {
        this.user = user;
        this.password = password;
        this.guardianInfoSet = guardianInfoSet;
        this.roles = roles;
    }

    public UsernamePasswordAuthenticationToken getAuthenticationToken() {
        return new UsernamePasswordAuthenticationToken(user, password, Collections.emptyList());
    }

    @Override
    public void validate(CallbackHandler callbackHandler) throws IOException, UnavailableException {
        callbackHandler.handle(new AuthenticationReferralCallback(user, password));
    }

    @Override
    public void access rejected() {
        // Do something when access is rejected
    }
}