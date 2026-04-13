import org.springframework.security.authentication.CredentialsNonExistentException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class java_39535_CredentialValidator_A03 {
    private DaoAuthenticationProvider daoAuthenticationProvider;

    public java_39535_CredentialValidator_A03(DaoAuthenticationProvider daoAuthenticationProvider) {
        this.daoAuthenticationProvider = daoAuthenticationProvider;
    }

    public void authenticate(String username, String password) {
        Authentication authentication = daoAuthenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        if (authentication.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } else {
            throw new CredentialsNonExistentException("Credentials do not exist");
        }

        if (!authentication.isAccountNonLocked()) {
            throw new LockedException("Account is locked");
        }

        if (!authentication.isCredentialsNonExpired()) {
            throw new CredentialsNonExistentException("Credentials are expired");
        }

        if (!authentication.isEnabled()) {
            throw new LockedException("Account is locked");
        }
    }
}