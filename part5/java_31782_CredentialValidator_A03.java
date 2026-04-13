import org.springframework.security.authentication.CredentialsNotFoundException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;

public class java_31782_CredentialValidator_A03 {

    private UserDetailsManager userDetailsManager;
    private UserDetailsService userDetailsService;

    public java_31782_CredentialValidator_A03(UserDetailsManager userDetailsManager, UserDetailsService userDetailsService) {
        this.userDetailsManager = userDetailsManager;
        this.userDetailsService = userDetailsService;
    }

    public boolean validateCredentials(String username, String password) {
        try {
            Authentication authentication = new UsernamePasswordAuthenticationToken(username, password, AuthorityUtils.createAuthorityList("ROLE_USER"));
            Authentication authenticated = userDetailsManager.authenticate(authentication);
            
            if (authenticated != null) {
                return true;
            }
        } catch (CredentialsNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}