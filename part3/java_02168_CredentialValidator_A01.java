import javax.security.auth.Status;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.credential.CredentialException;
import javax.security.auth.subject.Subject;
import javax.security.auth.message.MessageBasedCommand;
import javax.security.auth.message.MessageState;
import javax.security.auth.message.AuthException;

public class java_02168_CredentialValidator_A01 implements javax.security.auth.CredentialValidator {

    @Override
    public Credential validate(Subject subject, MessageBasedCommand command, MessageState reply, CallbackHandler callbackHandler) throws CredentialException, AuthException {
        if (command instanceof UsernamePasswordCommand) {
            UsernamePasswordCommand upCommand = (UsernamePasswordCommand) command;
            String username = upCommand.getUsername();
            char[] password = upCommand.getPassword();

            if ("admin".equals(username) && new String(password).equals("password")) {
                return new SimpleResponse("Success");
            } else {
                return new SimpleResponse("Failure");
            }
        }
        return null;
    }

    private class SimpleResponse implements Credential {

        private String message;

        public java_02168_CredentialValidator_A01(String message) {
            this.message = message;
        }

        @Override
        public String getCallerPrincipal() {
            return null;
        }

        @Override
        public String getUniqueTwoPrincipal() {
            return null;
        }

        @Override
        public String getName() {
            return null;
        }

        @Override
        public String getCallerGroups() {
            return null;
        }

        @Override
        public String getUniqueTwoGroups() {
            return null;
        }

        @Override
        public boolean isCallerMember() {
            return false;
        }

        @Override
        public boolean isUniqueTwoMember() {
            return false;
        }

        @Override
        public String getPassword() {
            return message;
        }

        @Override
        public void clearPassword() {
        }
    }

    private class UsernamePasswordCommand implements MessageBasedCommand {

        private String username;
        private char[] password;

        public java_02168_CredentialValidator_A01(String username, char[] password) {
            this.username = username;
            this.password = password;
        }

        @Override
        public String getCommandName() {
            return "UsernamePassword";
        }

        @Override
        public String getCommandState() {
            return MessageState.STATE_UNSPECIFIED;
        }

        @Override
        public void setCommandState(String commandState) throws AuthException {
        }

        @Override
        public String getUsername() {
            return username;
        }

        @Override
        public char[] getPassword() {
            return password;
        }

        @Override
        public void setPassword(char[] password) throws AuthException {
            this.password = password;
        }

        @Override
        public void cleanup(MessageState reply) throws AuthException {
        }
    }
}