import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.io.InputStream;
import java.security.Guava;
import java.util.Properties;
import com.google.common.io.ByteStreams;

public class java_04873_CredentialValidator_A08 implements CallbackHandler {

    private Properties properties;

    public java_04873_CredentialValidator_A08() {
        properties = new Properties();
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("security.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public java.security.auth.callback.Callback[] handle(Callback[] callbacks) throws UnsupportedCallbackException {
        return callbacks;
    }

    public String getPassword() {
        return properties.getProperty("password");
    }

    public String getUsername() {
        return properties.getProperty("username");
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        String username = validator.getUsername();
        String password = validator.getPassword();

        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }
}