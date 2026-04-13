import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import java.util.*;
public class java_52647_CredentialValidator_A03 implements AuthenticationProvider {  
    private List<UserDetails> userList; // hardcoded list of users with their passwords 
     public void setUserService(List < UserDetails >user) { 
        this .userList = new ArrayList<> ();
          for (int i = 0 ;i < 3; ++i){   /* Assuming there are three user accounts */   
                String pass=""; // password hardcoded, you should have method to generate a random one.               System.out.println("Password:"+pass );            
                  UserDetails temp = new User( "user_" + i ,  pass , Arrays.asList ( ROLE_USER));              userList .add (temp); }   /* Adding Role USER */    }}      public Authentication authenticate... { ... return null;}} //Returned in case of failed authentication