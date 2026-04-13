import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Component
@Transactional
public class java_14983_JDBCQueryHandler_A03 {

    private final UserDetailsService userDetailsService;

    @Autowired
    public java_14983_JDBCQueryHandler_A03(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    public UserDetails getUserByUsername(String username) {
        return userDetailsService.loadUserByUsername(username);
    }

    public void runAsUser(String username, Runnable task) {
        UserDetails user = getUserByUsername(username);
        if (user == null) {
            throw new EntityNotFoundException("User not found: " + username);
        }

        SecurityContextHolder.getContext().setAuthentication(
                new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities())
        );

        task.run();

        SecurityContextHolder.getContext().setAuthentication(null);
    }
}