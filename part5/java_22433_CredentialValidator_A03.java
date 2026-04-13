import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.handler.CallbackHandler;
import javax.security.auth.login.LoginContext;
import java.security.Principal;
import java.security.auth.Subject;
import java.util.Collections;

public class java_22433_CredentialValidator_A03 implements CallbackHandler {

    @Override
    public AuthenticationStatus callbackHandler(TokenRequest tokenRequest,
                                               Subject subject, Principal principal) throws IOException,
            UnavailableException {

        String schemeName = tokenRequest.getRequestScheme();
        if ("BASIC".equals(schemeName)) {
            return dealWithBasicScheme(tokenRequest, subject, principal);
        } else if ("CUSTOM".equals(schemeName)) {
            return dealWithCustomScheme(tokenRequest, subject, principal);
        }
        throw new IllegalArgumentException("Scheme not supported: " + schemeName);
    }

    private AuthenticationStatus dealWithBasicScheme(TokenRequest request, Subject subject, Principal principal) throws IOException, UnavailableException {
        String authToken = request.getRequestProperty("Authorization");
        // Use BASIC authentication (as requested)
        return AuthenticationStatus.SUCCESS;
    }

    private AuthenticationStatus dealWithCustomScheme(TokenRequest request, Subject subject, Principal principal) throws IOException, UnavailableException {
        // Implement custom authentication mechanism
        return AuthenticationStatus.SUCCESS;
    }
}