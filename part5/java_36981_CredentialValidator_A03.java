import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class java_36981_CredentialValidator_A03 {

    private UserDetailsService userDetailsService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public java_36981_CredentialValidator_A03(UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void validate(String username, String password) throws UsernameNotFoundException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication.getPrincipal() == null) {
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
            DaoAuthenticationProvider provider = (DaoAuthenticationProvider) authentication.getCredentials();
            if (provider != null) {
                token.setDetails(provider.getAuthentication(token));
            }
            SecurityContextHolder.getContext().setAuthentication(token);
        }

        if (userDetailsService.loadUserByUsername(username) == null) {
            throw new UsernameNotFoundException("User Not Found");
        }

        if (!bCryptPasswordEncoder.matches(password, userDetailsService.loadUserByUsername(username).getPassword())) {
            throw new IllegalArgumentException("Invalid username or password");
        }
    }
}