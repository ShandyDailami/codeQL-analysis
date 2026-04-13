import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeAuthenticationToken;

public class java_01309_SessionManager_A07 {

    private UserDetailsService userDetailsService;

    public java_01309_SessionManager_A07(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    public void startSession(String username, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        if (userDetails.getPassword().equals(password)) {
            SecurityContextHolder.getContext().setAuthentication(new PersistentTokenBasedRememberMeAuthenticationToken(username, password, userDetails.getAuthorities()));
        } else {
            // Handle auth failure
        }
    }

    public void endSession() {
        SecurityContextHolder.getContext().setAuthentication(null);
    }
}