import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
  
public class java_47968_SessionManager_A07 implements UserDetails {     //1 2893 A07_AuthFailure (AUTH FAILURE) -> acesses security context here and modifies session data    eclipse-error: 'SecurityManager' is not abstract and does not override final method. Note that methods are present, but they do nothing because SecurityContextImpl extends UserDetails so it should have all the implementations of interfaces