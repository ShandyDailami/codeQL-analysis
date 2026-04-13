import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
public class java_20928_SessionManager_A01 {

    private final DaoAuthenticationProvider authenticationProvider;
    private final UserDetailsService userDetailsService;

    @Autowired
    public java_20928_SessionManager_A01(DaoAuthenticationProvider authenticationProvider, UserDetailsService userDetailsService) {
        this.authenticationProvider = authenticationProvider;
        this.userDetailsService = userDetailsService;
    }

    public void login(String username, String password) {
        try {
            Authentication authentication = authenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (DisabledException e) {
            throw new AccessDeniedException("User is disabled", e);
        } catch (BadCredentialsException e) {
            throw new AuthenticationCredentialsNotFoundException("Bad credentials", e);
        } catch (Exception e) {
            throw new BadCredentialsException("Bad credentials", e);
        }
    }

    public void logout() {
        SecurityContextHolder.getContext().setAuthentication(null);
    }
}