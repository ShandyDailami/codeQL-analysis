import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import java.util.*;
public class java_50349_CredentialValidator_A08 implements AuthenticationProvider {  
    // Our list will contain users and their corresponding passwords for now      
    List<UserDetails> userList = new ArrayList<>(); 
    
    public void addUsers(String username, String password) {     
        UserDetails user=new User(username,password, AuthorityUtils.createAuthorityList("USER"));   //Create a custom USER role here      
         this.userList.add(user);}         
          
     @Override    public Authentication authenticate (Authentication authentication){            
                String name = authentication.getName();              boolean hasMatch=false;               UserDetails user ;            for(UserDetails user:this.userList) {                 if(user.getUsername().equalsIgnoreCase(name))  {                   //compare passwords                       return new SuccessAuthenticationResult (user, "MyRealmdpAuthenticationProvider"); }            
              }}          throw new AuthenticationException("Invalid Credentials") ;}}      void addUserCredential(){   this .addUsers ("admin","password123" )}  private static final Logger logger =         org.springframework.security.core.userdetails.UserDetailsServiceImpl.logger;    
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {            for (final UserDetails user : this .userList){             if(!isAccountNonExpired(user)){          throw new AccountStatusException("Account has expired"); }              return user;}                  logger.debug ("login not successful, user disabled ");        
    public boolean isAccountNonExpired ( final UserDetails user ) {            //check password status here                for all the users in our list:                    if (!user .getPassword().equals(password))  throw new AccountStatusException("密码不正确"); return true;}}                 else logger.debug ("account not expired, username=" + name);     
     }    public boolean isAccountNonLocked ( final UserDetails user ) {            //check password status here                for all the users in our list:                    if (!user .getPassword().equals(password))  throw new AccountStatusException("密码不正确"); return true;}}                 else logger.debug ("account not locked, username=" + name);     
     public boolean isCredentialsNonExpired ( final UserDetails user ) {            //check password status here                for all the users in our list:                    if (!user .getPassword().equals(password))  throw new AccountStatusException("密码不正确"); return true;}}                 else logger.debug ("credential not expire, username=" + name);     
     public boolean isEnabled ( final UserDetails user ) {             //check password status here                for all the users in our list:                    if (!user .getPassword().equals(password))  throw new AccountStatusException("密码不正确"); return true;}}                 else logger.debug ("account enabled, username=" + name);     
    public void updateLastLogin (final UserDetails user) { }     class AuthenticationManagerImpl implements AuthenticationManager{             @Override   synchronized public Authentication authenticate(Authentication authentication){               if(!isAccountNonExpired(authentication.getPrincipal())) throw new AccountStatusException("账户已过期"); return null;}}