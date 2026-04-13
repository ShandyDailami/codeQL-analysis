import javax.security.auth.login.LoginException;
import javax.security.auth.PasswordAuthentication;
import javax.security.auth.authenticator.Authenticator;
import javax.security.auth.authenticator.LoginContext;
import javax.security.auth.login.AppLoginModule;

public class java_10457_CredentialValidator_A03 implements Authenticator {

    private String username;
    private String password;

    public java_10457_CredentialValidator_A03(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public PasswordAuthentication getPasswordAuthentication() throws LoginException {
        String authResult = null;
        try {
            AppLoginModule loginModule = new AppLoginModule(username, password);
            LoginContext loginContext = new LoginContext("MyRealm", loginModule);
            loginContext.login();
            authResult = loginContext.getCallerIdentity().getID();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new PasswordAuthentication() {
            @Override
            public String getCaller() {
                return authResult;
            }

            @Override
            public String getID() {
                return authResult;
            }
        };
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            CustomAuthenticator authenticator = new CustomAuthenticator("username", "password");
            PasswordAuthentication authentication = authenticator.getPasswordAuthentication();
            System.out.println("Authenticated as: " + authentication.getCaller());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}