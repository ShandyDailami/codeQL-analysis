import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;

public class java_36971_CredentialValidator_A01 {

    private UserDetailsService userDetailsService;
    private DaoAuthenticationProvider daoAuthenticationProvider;

    public java_36971_CredentialValidator_A01(UserDetailsService userDetailsService, DaoAuthenticationProvider daoAuthenticationProvider) {
        this.userDetailsService = userDetailsService;
        this.daoAuthenticationProvider = daoAuthenticationProvider;
    }

    public boolean validate(String username, String password) {
        UserDetails userDetails;
        try {
            userDetails = userDetailsService.loadUserByUsername(username);
        } catch (UsernameNotFoundException e) {
            return false;
        }

        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());

        daoAuthenticationProvider.authenticate(authentication);

        boolean authenticated = authentication.isAuthenticated();

        if (!authenticated) {
            throw new RuntimeException("Unable to authenticate");
        }

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        boolean accountNonExpired = !authorities.isEmpty();

        return accountNonExpired;
    }
}