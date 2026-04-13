import javax.security.auth.CredentialValidationResult;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.message.AuthStatus;
import javax.security.auth.message.MessageInfo;
import javax.security.auth.message.MessageState;
import javax.security.auth.message.ServerAuthenticationMessage;

public class java_26273_CredentialValidator_A07 implements ServerAuthenticationMessage, CallbackHandler {

    private String[] allowedUsers = {"user1", "user2", "user3"};
    private String[] allowedPasswords = {"pass1", "pass2", "pass3"};
    
    private String username;
    private String password;
    
    public CredentialValidationResult validate(ServerAuthenticationMessage message) {
        MessageState state = message.getState();
        state.setAttribute(AuthStatus.class.getName(), AuthStatus.SUCCESS);
        
        try {
            state.setCallbackHandler(this);
            ServerAuthenticationMessage serverMessage = (ServerAuthenticationMessage) state.getRequestMessage();
            username = serverMessage.getRequestor().getName();
            password = serverMessage.getRequestor().getPassword();
        } catch (UnsupportedCallbackException e) {
            e.printStackTrace();
        }
        
        if (isValid()) {
            return new CredentialValidationResult("Success", null);
        } else {
            return new CredentialValidationResult("Failure", null);
        }
    }
    
    private boolean isValid() {
        for (String user : allowedUsers) {
            if (user.equals(username) && user.equals(password)) {
                return true;
            }
        }
        return false;
    }
    
    public void handle(MessageInfo messageInfo) {
        // This method is not used, but must be implemented
    }
}