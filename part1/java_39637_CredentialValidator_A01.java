import javax.security.auth.callback.*;
import javax.security.auth.UsernamePasswordCredential;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_39637_CredentialValidator_A01 implements CallbackHandler {

    private Set<CredentialEntry> credentials;

    public java_39637_CredentialValidator_A01() {
        credentials = new HashSet<>();
        credentials.add(new UsernamePasswordCredential("user", "password".toCharArray()));
    }

    @Override
    public CallbackHandler getCallbackHandler() {
        return this;
    }

    @Override
    public boolean getCredentials(Callback[] callbacks) throws IOException, InterruptedException {
        if (callbacks.length == 0) {
            return false;
        }
        for (Callback callback : callbacks) {
            if (callback instanceof UsernamePasswordCallback) {
                UsernamePasswordCallback callback2 = (UsernamePasswordCallback) callback;
                for (CredentialEntry credential : credentials) {
                    if (Arrays.equals(credential.getUsername().getBytes(), callback2.getPrompt().getBytes())) {
                        callback2.setPassword(credential.getPassword());
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean refresh() {
        return false;
    }

    public static void main(String[] args) {
        CustomCredential credential = new CustomCredential();
        System.out.println("Credential validator: " + credential.getClass().getName());
    }
}