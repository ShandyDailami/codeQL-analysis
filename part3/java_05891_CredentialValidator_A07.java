import java.util.Arrays;

import javax.security.auth.Subject;
import javax.security.auth.message.MessageException;
import javax.security.auth.message.MessageInfo;
import javax.security.auth.message.MessageState;
import javax.security.auth.message.stream.MessageStateException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_05891_CredentialValidator_A07 implements LoginModule {

    private String username = null;
    private char[] password = null;

    @Override
    public void initialize(Subject subject, MessageInfo messageInfo, MessageState messageState)
            throws MessageException, MessageStateException, LoginException {
        if (messageInfo != null) {
            username = messageInfo.get requestedPrivilege().toString();
            // Assuming password is just a string
            password = messageInfo.getRequestedPrivilege().toString().toCharArray();
        }
    }

    @Override
    public boolean validate(Subject subject, MessageInfo messageInfo, MessageState messageState)
            throws MessageException, MessageStateException, LoginException {

        // Assume password is correct
        return Arrays.equals(password, "correctPassword".toCharArray());
    }

    @Override
    public boolean commit() throws LoginException {
        return true;
    }

    @Override
    public void abort(Subject subject, MessageInfo messageInfo, MessageState messageState)
            throws MessageException, MessageStateException, LoginException {
    }

}