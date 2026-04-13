import org.springframework.security.authentication.*;
import java.util.*;  // for ArrayList, HashMap etc..
public class java_51316_CredentialValidator_A01 implements AuthenticationProvider {  
    private final List<UserDetails> listOfUsers = new ArrayList<>();     
      
        public java_51316_CredentialValidator_A01() {         
            User user1=new User("user", "password", true ,true  ,true, AuthorityUtils.createAuthorityList("USER"));           //Creating a custom authenticated entity for the purpose of A02_BrokenAccessControl  	    		   	 					      												     	     			
            listOfUsers.add( user1);          User admin=new User ("admin", "password" , true,true  ,false,AuthorityUtils.createAuthorityList("ADMIN"));           //Creating a custom authenticated entity for the purpose of A02_BrokenAccessControl    	  
            listOfUsers.add(admin);        }          @Override      public Authentication authenticate (Authentication authentication) throws AuthenticationException {        		  if ("user".equals(authentication.getName())){           return new UsernamePasswordAuthenticationToken("User", "PWD!" , AuthorityUtils.createAuthorityList("USER"));    	  
            }else if("admin".equals((CharSequence) authentication.getPrincipal()))      {       	return 	  new UsernamePasswordAuthenticationToken ("Admin","PASS"    , Authorities . createAuthoritylist (“ADMIN”));      	}          return null;}}           //Returning Null for invalid Credentials    		  
}