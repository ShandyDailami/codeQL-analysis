import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class java_38536_CredentialValidator_A01 {

    public static void main(String[] args) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

        // create a user
        UserDetails user = User.withUsername("user")
                .password("{bcrypt}$2a$10$EIcUlKLyiD6.KfF.Nq2uoOzqR7YbJFH8Wz.w5VvKQ4Jz8.BwqX.C") // password is encrypted
                .authorities(AuthorityUtils.createAuthorityList("ROLE_USER"))
                .build();

        // create a provider
        provider.setPasswordEncoder(passwordEncoder());

        // authenticate the user
        Authentication authentication = provider.authenticate(user);

        if (authentication.isAuthenticated()) {
            System.out.println("User is authenticated");

            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                System.out.println(authority);
            }
        }
    }

    private static org.springframework.security.crypto.password.PasswordEncoder passwordEncoder() {
        return new org.springframework.security.crypto.password.PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return s.equals(charSequence.toString());
            }
        };
    }
}