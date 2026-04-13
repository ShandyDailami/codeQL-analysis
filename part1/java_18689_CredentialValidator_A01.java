import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.security.Principal;
import java.security.auth.Authenticator;
import java.security.auth.GrantedAuthority;
import java.util.ArrayList;
import java.util.List;

public class java_18689_CredentialValidator_A01 implements LoginModule {

    private String username;
    private String password;
    private Subject subject;

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler,
                           String username, String password) throws LoginException {
        this.subject = subject;
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean login() throws LoginException {
        if (username.equals("admin") && password.equals("password")) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new org.opensourcecredentials.AuthorityImpl("ROLE_ADMIN"));
            Principal principal = new PrincipalImpl("admin", authorities);
            subject.getPrincipals().removeAll();
            subject.getGrantedAuthorities().removeAll();
            subject.getGrantedAuthorities().addAll(authorities);
            subject.getPrincipals().add(principal);
            return true;
        } else {
            throw new LoginException("Login failed");
        }
    }
}

public class CustomAuthenticator implements Authenticator {

    private List<LoginModule> loginModules;

    public java_18689_CredentialValidator_A01() {
        loginModules = new ArrayList<>();
    }

    @Override
    public Subject authenticate(Subject subject, String username, String password) throws LoginException {
        if (loginModules != null && loginModules.size() > 0) {
            for (LoginModule loginModule : loginModules) {
                loginModule.initialize(subject, null, username, password);
                if (loginModule.login()) {
                    return subject;
                }
            }
        }
        return null;
    }
}

public class CustomSubject extends Subject {

    private List<Principal> principals;
    private List<GrantedAuthority> authorities;

    public java_18689_CredentialValidator_A01(List<Principal> principals, List<GrantedAuthority> authorities) {
        this.principals = principals;
        this.authorities = authorities;
    }

    @Override
    public List<Principal> getPrincipals() {
        return principals;
    }

    @Override
    public List<GrantedAuthority> getGrantedAuthorities() {
        return authorities;
    }
}

public class PrincipalImpl implements Principal {

    private String name;
    private List<GrantedAuthority> authorities;

    public java_18689_CredentialValidator_A01(String name, List<GrantedAuthority> authorities) {
        this.name = name;
        this.authorities = authorities;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<GrantedAuthority> getAuthorities() {
        return authorities;
    }
}

public class AuthorizationExample {

    public static void main(String[] args) throws LoginException {
        Authenticator authenticator = new CustomAuthenticator();
        Subject subject = authenticator.authenticate(null, "admin", "password");
        if (subject != null) {
            System.out.println("Authenticated successfully!");
        } else {
            System.out.println("Authentication failed!");
        }
    }
}