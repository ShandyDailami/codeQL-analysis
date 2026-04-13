import javax.security.auth.CredentialValidationResult;
import javax.security.auth.callback.*;
import javax.security.auth.message.MessageState;
import javax.security.auth.message.MessageContext;

public class java_05374_CredentialValidator_A08 implements javax.security.auth.CredentialValidator {

    // This method will be called by the security framework when it needs to validate user credentials
    @Override
    public CredentialValidationResult validate(MessageContext messageContext) throws java.lang.Exception {
        // Get the callback handler for getting user credentials
        CallbackHandler callbackHandler = messageContext.getCallbackHandler();

        // Get the user name and password
        UsernamePasswordCallback c = new UsernamePasswordCallback("", "");
        callbackHandler.handle(new Callback[] { c });

        // Check if the user name and password are correct
        if ("admin".equals(c.getUsername()) && "password".equals(c.getPassword())) {
            return CredentialValidationResult.VALID;
        } else {
            return CredentialValidationResult.INVALID;
        }
    }
}