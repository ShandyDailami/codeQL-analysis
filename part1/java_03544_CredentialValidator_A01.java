import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_03544_CredentialValidator_A01 implements CallbackHandler {

    private Map<String, String> credentials;

    public java_03544_CredentialValidator_A01() {
        credentials = new HashMap<>();
        credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    @Override
    public String getPassword(String userName) throws UnsupportedCallbackException {
        String password = credentials.get(userName);
        if (password == null) {
            throw new UnsupportedCallbackException("User not found");
        }
        return password;
    }

    @Override
    public String getUsername(String userName) throws UnsupportedCallbackException {
        return userName;
    }

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        // Not implemented
    }
}

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginContext;
import javax.security.auth.spi.LoginModule;
import java.security.Permission;

public class MyLoginModule implements LoginModule {

    private CallbackHandler callbackHandler;

    public java_03544_CredentialValidator_A01(CallbackHandler callbackHandler) {
        this.callbackHandler = callbackHandler;
    }

    @Override
    public Subject login() {
        return login(null);
    }

    @Override
    public Subject login(String callerQualifiedName) {
        return login(null, null, callerQualifiedName);
    }

    @Override
    public Subject login(String callerQualifiedName, String callerPassword, String argument) {
        MySubject subject;
        try {
            Subject subject = Subject.getSubject(callerQualifiedName, callbackHandler, callerPassword, argument);
            subject.getPrivateCredentialsMap(); // This will fail if the user is not allowed to access the credentials
            subject.getPublicCredentialsMap(); // This will fail if the user is allowed to access the credentials
            subject.getGrantedPermissions(); // This will fail if the user is not allowed to access the permissions
            subject.getGrantedAuthorities(); // This will fail if the user is not allowed to access the authorities
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return subject;
    }

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, String> map) throws IOException, UnsupportedCallbackException {
        this.callbackHandler = callbackHandler;
    }

    @Override
    public void uninstall(Subject subject) {
        // Not implemented
    }

    @Override
    public Permission[] getPermissions(Subject subject) {
        // Not implemented
        return new Permission[0];
    }

    @Override
    public String getRoles(Subject subject) {
        // Not implemented
        return null;
    }

    @Override
    public String getPrivateCredential(Subject subject, String s) throws UnsupportedCallbackException {
        return null;
    }

    @Override
    public String getPublicCredential(Subject subject, String s) throws UnsupportedCallbackException {
        return null;
    }

    @Override
    public String[] getPrivateCredentials(Subject subject) throws UnsupportedCallbackException {
        return new String[0];
    }

    @Override
    public String[] getPublicCredentials(Subject subject) throws UnsupportedCallbackException {
        return new String[0];
    }
}

import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

public class MySubject extends Subject {

    private Map<String, Object> privateCredentialsMap;
    private Map<String, Object> publicCredentialsMap;

    public java_03544_CredentialValidator_A01(String callerQualifiedName) throws GeneralSecurityException, LoginException {
        super(callerQualifiedName);
        privateCredentialsMap = new HashMap<>();
        publicCredentialsMap = new HashMap<>();
    }

    @Override
    public Map<String, Object> getPrivateCredentialsMap() {
        return privateCredentialsMap;
    }

    @Override
    public Map<String, Object> getPublicCredentialsMap() {
        return publicCredentialsMap;
    }

    @Override
    public void setPrivateCredentialsMap(Map<String, Object> map) {
        privateCredentialsMap = map;
    }

    @Override
    public void setPublicCredentialsMap(Map<String, Object> map) {
        publicCredentialsMap = map;
    }
}