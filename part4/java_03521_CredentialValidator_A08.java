import javax.security.auth.Credential;
import javax.security.auth.PasswordBroker;
import javax.security.auth.PasswordBrokerCredential;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.util.Arrays;

public class java_03521_CredentialValidator_A08 implements PasswordBroker {
    // Hard-coded passwords.
    private static final String[] hardCodedPasswords = {"password1", "secure123"};

    @Override
    public String getPassword(String userName, String CallerQualifier) throws IOException {
        if (Arrays.asList(hardCodedPasswords).contains(userName)) {
            return userName;
        } else {
            throw new IOException("Invalid username or password");
        }
    }

    @Override
    public Credential validate(String arg0, String arg1, String arg2) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getCallerPrincipal(String arg0) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean setCallbackHandler(CallbackHandler arg0) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void validate(Credential credential) throws IOException {
        throw new UnsupportedOperationException();
    }
}

public class Main {
    public static void main(String[] args) {
        Credential credential = new MyPasswordBroker();
        String password = "password1";

        boolean success = credential.validate(password, null, null);

        if (success) {
            System.out.println("Login successful");
        } else {
            System.out.println("Invalid password");
        }
    }
}