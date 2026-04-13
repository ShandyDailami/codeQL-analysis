import java.util.HashMap;
import javax.security.auth.CredentialException;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;
import javax.security.auth.login.AppLoginModule;

public class java_24431_CredentialValidator_A07 extends AppLoginModule {

    private HashMap<String, String> userDb;

    public java_24431_CredentialValidator_A07() {
        userDb = new HashMap<>();
        userDb.put("user1", "password1");
        userDb.put("user2", "password2");
        userDb.put("user3", "password3");
    }

    @Override
    public String getPassword(String loginName) throws CredentialException {
        return userDb.get(loginName);
    }

    @Override
    public String getCaller(String loginName) throws CredentialException {
        return "unknown";
    }

    @Override
    public boolean validate(UsernamePasswordCredential arg0) throws CredentialException {
        if (userDb.containsKey(arg0.getIdentifier()) && userDb.get(arg0.getIdentifier()).equals(arg0.getCredential())) {
            return true;
        } else {
            throw new CredentialException("Invalid username or password");
        }
    }
}