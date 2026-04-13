import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class java_12559_SessionManager_A07 {

    private final UserDetailsService userDetailsService;

    public java_12559_SessionManager_A07(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    public UserDetails getLoggedInUser() {
        return (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public void login(String username, String password) throws UsernameNotFoundException {
        UserDetails user = userDetailsService.loadUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities()));
        } else {
            throw new UsernameNotFoundException("Invalid username or password");
        }
    }

    public void logout() {
        SecurityContextHolder.getContext().setAuthentication(null);
    }
}