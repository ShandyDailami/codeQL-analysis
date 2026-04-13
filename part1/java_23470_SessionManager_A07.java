import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class java_23470_SessionManager_A07 implements UserDetailsService {

    private final SessionRegistry sessionRegistry;

    public java_23470_SessionManager_A07(SessionRegistry sessionRegistry) {
        this.sessionRegistry = sessionRegistry;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        // This is a dummy implementation and should not be used in a real application.
        // The real implementation should retrieve the user details from the database.
        if ("admin".equals(username)) {
            return new UserDetails() {
                @Override
                public Collection<? extends GrantedAuthority> getAuthorities() {
                    return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
                }

                @Override
                public String getPassword() {
                    return "$2a$10$e.W5425.Q6Hj2v3f9.j9u6jK.O7OoQv.Q8fWi7.E.T/fXe.O050f.NU"; // "password"
                }

                @Override
                public String getUsername() {
                    return username;
                }

                @Override
                public boolean isAccountNonExpired() {
                    return true;
                }

                @Override
                public boolean isAccountNonLocked() {
                    return true;
                }

                @Override
                public boolean isCredentialsNonExpired() {
                    return true;
                }

                @Override
                public boolean isEnabled() {
                    return true;
                }
            };
        } else {
            throw new UsernameNotFoundException("No user found with username: " + username);
        }
    }
}

public class MySessionRegistry implements SessionRegistry {

    private final Map<String, SessionInformation> sessions = new ConcurrentHashMap<>();

    @Override
    public String getSessionId() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    @Override
    public List<SessionInformation> getAllSessions(Principal principal) {
        return sessions.values().stream().filter(session -> session.getPrincipal().equals(principal)).collect(Collectors.toList());
    }

    @Override
    public SessionInformation getSessionInformation(String sessionId) {
        return sessions.get(sessionId);
    }

    @Override
    public void refresh(String sessionId) {
        // This is a dummy implementation and should not be used in a real application.
        // The real implementation should refresh the session information in the database.
    }

    @Override
    public void registerNewSession(String sessionId, Principal principal) {
        sessions.put(sessionId, new SessionInformation(principal, new Date()));
    }

    @Override
    public void refresh(Principal principal) {
        // This is a dummy implementation and should not be used in a real application.
        // The real implementation should refresh the session information for the given principal in the database.
    }

    @Override
    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }
}