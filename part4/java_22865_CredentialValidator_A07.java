import java.util.Base64;
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth. UsernamePasswordAuthenticationToken;
import javax.security.auth.message.MessageException;
import javax.security.auth.message.MessageState;
import javax.security.auth.message.MessageStateRejector;

public class java_22865_CredentialValidator_A07 implements CallbackHandler, MessageStateRejector {

    private String username;
    private String password;

    public java_22865_CredentialValidator_A07(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean checkRequestedState(MessageState messageState) throws MessageException {
        return true;
    }

    @Override
    public boolean commit(MessageState messageState) throws MessageException {
        return true;
    }

    @Override
    public boolean abort(MessageState messageState) throws MessageException {
        return false;
    }

    @Override
    public boolean handle(Callback callback, MessageState messageState) throws UnsupportedCallbackException, MessageException {
        UsernamePasswordAuthenticationToken userToken = (UsernamePasswordAuthenticationToken) callback;
        String user = userToken.getUserName();
        String pass = new String(Base64.getDecoder().decode(userToken.getPassword()));
        if (user.equals(this.username) && pass.equals(this.password)) {
            return true;
        } else {
            return false;
        }
    }
}