import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class java_11150_CredentialValidator_A03 implements CredentialValidator {

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        String username = auth.getName();
        String password = (String) auth.getCredentials();

        // Here we're only checking for a username and password, not checking if the credentials match a user in our database
        // You'd normally use a database to check these credentials
        if (username.equals("admin") && password.equals("password")) {
            return new Authentication() {
                @Override
                public String getName() {
                    return username;
                }

                @Override
                public Object getCredentials() {
                    return password;
                }

                @Override
                public Object getDetails() {
                    return null;
                }

                @Override
                public Set<SimpleGrantedAuthority> getAuthorities() {
                    return null;
                }

                @Override
                public boolean isAuthenticated() {
                    return true;
                }

                @Override
                public void setAuthenticated(boolean authenticated) throws IllegalArgumentException {
                    throw new IllegalStateException(
                        "Can't set this authentication state manually"
                    );
                }
            };
        } else {
            throw new BadCredentialsException("Invalid credentials");
        }
    }
}