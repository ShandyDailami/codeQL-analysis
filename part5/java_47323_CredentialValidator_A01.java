public class java_47323_CredentialValidator_A01 {
    private String userName; // assuming all users are authenticated by their names. For real world application you should use actual authentication/authorization mechanism (like Spring Security).  
	private List<String> roles = new ArrayList<>();    
}
// ... And similarly we have UserDetails and Authentication: 
public class MyUserDetails extends UserDetails {    // implementations of these interfaces for security. In real world scenario you should use actual implementation or one provided by Spring Security (like in case above example).  
	...
	public List<GrantedAuthority> getAuthorities() { ... }      - return roles as authorities – this is required method implemented here, same way role names from user object are passed.   
}       // UserDetails implementations done by Spring Security itself (like in case above example).