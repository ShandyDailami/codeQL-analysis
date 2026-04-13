import java.security.GuardianInfo;
import java.security.GuardianInfoService;
import java.security.GuardianInfoService.GuardianInfoResult;
import java.security.GuardianSecurityManager;
import java.security.GuardianSecurityManager.AuthInfo;
import java.security.GuardianSecurityManager.LoginException;
import java.security.GuardianSecurityManager.AuthInfo.LoginModuleControl;
import java.security.GuardianSecurityManager.AuthInfo.SubjectIdentifier;
import java.security.GuardianSecurityManager.AuthInfo.SubjectIdentifier.SubjectRequest;
import java.security.GuardianSecurityManager.AuthInfo.SubjectRequest.SubjectRequestOption;
import java.security.GuardianSecurityManager.SubjectRequestAuthInfo.SubjectRequestAuthInfoOption;

public class java_30622_CredentialValidator_A03 {
    public static void main(String[] args) {
        try {
            validate();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void validate() throws LoginException {
        // Create a Guardian Security Manager
        GuardianSecurityManager gsm = new GuardianSecurityManager();

        // Get the Guardian Info
        GuardianInfo info = gsm.getGuardianInfo();

        // Get the subject identifier
        SubjectIdentifier subj = info.getSubjectIdentifier();

        // Create a request for authentication
        SubjectRequest request = subj.createSubjectRequest(null, true);

        // Set the request option
        request.setOption(SubjectRequestOption.KerberosTicket, true);

        // Authenticate the request
        AuthInfo authInfo = request.authenticate(info);

        // Get the login module control
        LoginModuleControl control = authInfo.getLoginModuleControl();

        // Get the authentication status
        boolean authenticated = control.isAuthenticated();

        // Print the authentication status
        System.out.println("Authenticated: " + authenticated);
    }
}