import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.security.auth.UsernamePasswordAuthenticationToken;
import javax.security.auth.password.PasswordAuthenticationToken;
import javax.security.auth.login.LoginException;

public class java_41398_CredentialValidator_A03 implements CallbackHandler {

    private Properties props;

    public java_41398_CredentialValidator_A03() {
        this.props = new Properties();

        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("credentials.properties");

            props.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public PasswordAuthenticationToken getPasswordAuthenticationToken(String username, String[] passwords, CallbackHandler callbackHandler) throws IOException, LoginException, UnsupportedCallbackException {

        String password = props.getProperty(username);

        if (password != null) {
            return new UsernamePasswordAuthenticationToken(username, password);
        } else {
            throw new LoginException("Invalid username or password");
        }
    }

    @Override
    public CallbackHandler getCallbackHandler() {
        return this;
    }
}