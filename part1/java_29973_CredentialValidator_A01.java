import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_29973_CredentialValidator_A01 implements LoginModule {
    private String username = "user";
    private String password = "password";

    @Override
    public Credential validate(Credential credential) {
        String providedUsername = credential.getAlgorithmDetail().getIdentifier();
        String providedPassword = new String(credential.getCredentialIdentifier());

        if (username.equals(providedUsername) && password.equals(providedPassword)) {
            return new UsernamePasswordCredential(username, password);
        } else {
            throw new LoginException("Invalid username or password");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            javax.security.auth.Subject subject = new javax.security.auth.Subject();
            subject.getPrincipals().clear();
            subject.getGrantedAuthorities().clear();

            MyLoginModule loginModule = new MyLoginModule();
            subject.getGrantedAuthorities().add(new org.jboss.security.auth.spi.GrantedAuthorityImpl("ROLE_USER"));
            subject.setRealm(new org.jboss.security.auth.spi.DatabaseRealm(new org.jboss.security.auth.spi.credential.PasswordEncryptionRealm()));
            subject.setCredentials(LoginModule.class.getName(), loginModule);

            subject.login();
            System.out.println("Login Successful");
        } catch (LoginException e) {
            System.out.println("Failed to authenticate: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected Exception: " + e.getMessage());
        }
    }
}