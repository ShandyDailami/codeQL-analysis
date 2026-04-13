import javax.security.auth.login.CredentialAuthenticationException;
import javax.security.auth.password.PasswordAuthentication;

public class java_35369_CredentialValidator_A03 {

    public PasswordAuthentication validate(String username, String password) {
        // Plaintext password validation
        if ("username".equals(username) && "password".equals(password)) {
            return new PasswordAuthentication() {
                @Override
                public String getName() {
                    return username;
                }

                @Override
                public String getCallerPrincipal() {
                    return username;
                }

                @Override
                public String getPassword() {
                    return password;
                }

                @Override
                public String[] getGrantedAuthorities() {
                    return new String[]{};
                }
            };
        } else {
            throw new CredentialAuthenticationException("Invalid username or password");
        }
    }
}