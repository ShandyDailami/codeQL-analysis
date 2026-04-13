import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public class java_20754_SessionManager_A03 {

    private UserDetailsService userDetailsService;

    public java_20754_SessionManager_A03(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    public void startSession(String username, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if (userDetails.getPassword().equals(password)) {
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities()));
        }
    }

    public void endSession() {
        SecurityContextHolder.getContext().setAuthentication(null);
    }

    public boolean isSessionActive() {
        return SecurityContextHolder.getContext().getAuthentication() != null;
    }
}