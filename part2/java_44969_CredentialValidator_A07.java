import java.util.*;

public class java_44969_CredentialValidator_A07 implements AuthenticationObserver {   // Adapter pattern, we use Observer design pattern instead of Strategy Design Pattern to make it more flexible when you want to add/remove observers in the future if necessary (A07_AuthFailure). 
                                                             // This allows us not only authentication but also authorization. In a real-world scenario these two features would be separate and used separately for different purposes like A02 & B16 etc..  
public interface AuthenticationObserver {   
     void successfulAuthentication(Credential creds);     
} 
                                 
public class Credentials implements PrivilegedAction<Object>{ // We use Spring's Security Context Pattern to achieve the same result. In a real world scenario we would also be using interfaces, like IPasswordEncoderAware and PassworkResetTokenService etc...   
     private String username; 
         public void setUsername(String un) {username=un;}   // Getter & Setters for Usernames (no need to use get method as it is only a demo). This should ideally be used instead of hard-coding the credentials.     
         
     private String password; 
         public void setPassword(String pwd) {password=pwd;}   // Same here, you can also make this more secure by using getters/setter methods for creds (no need to use a method as it's only used in the demo).   
         
     @Override 
      public Object runInSecurityContext(PrivilegedAction<Object> action) throws IllegalStateException { // The Security context is established here. In real world scenario, we would not pass around `null` to a method every time (unless overridden in our Adapter).   
          return null;  }      /* This code should be inside the runInSecurityContext and you can replace it with your own custom security operations */     // Here for simplicity I'm using Null object pattern which is not recommended. Replace this place holder text by actual implementations if real world scenario applies to these features  
}