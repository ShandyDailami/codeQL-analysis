import javax.security.auth.callback.*;
import javax.security.auth.UsernamePasswordAuthenticationToken;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class java_10551_CredentialValidator_A03 implements CallbackHandler {

    private static final Map<String, String> users = new HashMap<>();

    static {
        users.put("user1", "password1");
        users.put("user2", "password2");
        users.put("user3", "password3");
    }

    @Override
    public AuthenticationStatus callbackHandler(CallbackHandlerCallback callbackHandler, Map<String, Object> currentCredentials) throws LoginException, IOException {
        UsernamePasswordAuthenticationToken token = null;

        // Get the username and password from the current credentials map
        String id = currentCredentials.get("id").toString();
        String password = currentCredentials.get("password").toString();

        // Validate the password
        if (password.equals(users.get(id))) {
            token = new UsernamePasswordAuthenticationToken(id, password, Arrays.asList(roles(id)));
            return AuthenticationStatus.SUCCESSFULL;
        } else {
            return AuthenticationStatus.FAILURE;
        }
    }

    private String[] roles(String id) {
        // This is a placeholder. In a real application, you would query the database for the roles of the user
        if ("user1".equals(id)) {
            return new String[]{"ROLE_USER"};
        } else if ("user2".equals(id)) {
            return new String[]{"ROLE_USER", "ROLE_ADMIN"};
        } else if ("user3".equals(id)) {
            return new String[]{"ROLE_ADMIN"};
        }
        return new String[0];
    }

    public static void main(String[] args) {
        CustomCredentialValidator validator = new CustomCredentialValidator();
        CallbackHandler handler = new CallbackHandler() {
            @Override
            public AuthenticationStatus callbackHandler(CallbackHandlerCallback callbackHandler) throws IOException, LoginException {
                return validator.callbackHandler(callbackHandler, null);
            }
        };
        // Use the handler in a login process
    }
}