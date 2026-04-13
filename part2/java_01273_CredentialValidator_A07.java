import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;

import javax.management.AuthenticationFailedException;
import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import javax.management.MXBean;

public class java_01273_CredentialValidator_A07 implements CredentialValidator {

    private Map<String, String> credentials = new HashMap<>();

    public java_01273_CredentialValidator_A07() {
        // Add your credentials to the credentials map
        // This should be in the form of username:password
        this.credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        this.credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    @Override
    public boolean validate(Subject subject, String username, String password)
            throws AuthenticationFailedException {

        // Decode the password
        byte[] decodedPassword = Base64.getDecoder().decode(this.credentials.get(username));

        // Compare the passwords
        if (new String(decodedPassword).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

}