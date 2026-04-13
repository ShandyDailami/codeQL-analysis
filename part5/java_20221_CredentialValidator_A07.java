import javax.security.auth.callback.*;
import javax.security.auth.login.*;
import javax.security.auth.x500.X500Principal;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

public class java_20221_CredentialValidator_A07 implements CallbackHandler {

    private Map<String, String> credentials;

    public java_20221_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
    }

    public void addCredential(String realm, String username, String password) {
        this.credentials.put(realm, username);
        System.out.println("Credentials for realm " + realm + " added.");
    }

    @Override
    public CallbackHandler getCallbackHandler() {
        return this;
    }

    @Override
    public boolean validate(CallbackHandler callbackHandler, Map<String, Object> map) throws IOException {
        callbackHandler.process(callbacks(map));
        return true;
    }

    private Callback[] callbacks(Map<String, Object> credentials) {
        ListCallback list = new ListCallback();
        SetCallback set = new SetCallback();

        for (Map.Entry<String, String> entry : credentials.entrySet()) {
            set.put(new String[] { "name", entry.getKey() }, new String[] { entry.getValue() });
            list.put(new String[] { "entry", String.valueOf(set.size() - 1) }, set);
        }

        return new Callback[] { list };
    }

    public static void main(String[] args) throws Exception {
        CustomCredentialValidator validator = new CustomCredentialValidator();
        validator.addCredential("myRealm", "user1", "password1");
        validator.addCredential("myRealm", "user2", "password2");

        MyLoginModule myLoginModule = new MyLoginModule("user3", "password3", false);
        MyCallbackHandler callbackHandler = new MyCallbackHandler();

        callbackHandler.validate(new AuthenticationInfo[]{myLoginModule}, new MapStore());
    }
}