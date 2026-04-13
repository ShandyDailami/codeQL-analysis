import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class java_20903_CredentialValidator_A03 implements CredentialValidator {

    private List<String> validUsers;

    public java_20903_CredentialValidator_A03() {
        validUsers = new ArrayList<>();
        validUsers.add("user1");
        validUsers.add("user2");
        validUsers.add("user3");
        validUsers.add("user4");
        validUsers.add("user5");
    }

    @Override
    public boolean validate(Subject subject, Credential credential) throws IOException, UnsupportedCallbackException {
        String username = credential.getCredentialIdentifier();
        return validUsers.contains(username);
    }

    @Override
    public CallbackHandler getCallbackHandler() {
        return null;
    }
}