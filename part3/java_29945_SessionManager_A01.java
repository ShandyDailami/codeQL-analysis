import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class java_29945_SessionManager_A01 {

    public void startSession(HttpServletRequest request) {
        Authentication authentication = SecurityContextHolder.createEmptyContext();
        authentication.setAuthenticated(false);
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    public void endSession() {
        SecurityContextHolder.getContext().setAuthentication(null);
    }

    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}