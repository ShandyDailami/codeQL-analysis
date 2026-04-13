import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.usernamepassword.UsernamePasswordAuthenticationMechanism;
import javax.security.auth.usernamepassword.UsernamePasswordMechanismException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class java_05065_CredentialValidator_A08 implements CallbackHandler {

    private Properties props = new Properties();
    private InputStream inputStream;

    public java_05065_CredentialValidator_A08() {
        try {
            inputStream = getClass().getResourceAsStream("/credentials.properties");
            props.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Callback[] getCallbacks() {
        return new Callback[]{
                new UsernamePasswordCallback("User Name: ")
        };
    }

    @Override
    public String getPassword(String userName) {
        return props.getProperty(userName);
    }

    @Override
    public boolean validate(String userName, String password) {
        if(userName.equals(props.getProperty(userName)) && password.equals(props.getProperty(password))) {
            return true;
        } else {
            return false;
        }
    }
}