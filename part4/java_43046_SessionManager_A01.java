import javax.security.auth.*;
import javax.security.auth.message.AuthException;

public class java_43046_SessionManager_A01 {
    // Assume we have a method called authenticate which returns User object or throws AuthException if failed to auth
     public static java.util.Optional<javax.security.auth.User> authenticate(String username, String password) 
         throws UnavailableSecurityException{     
        try {            
            // Here we are using a simple equals method for comparison which is NOT secure against attacks such as Cross-Site Scripting (XSS), CSRF etc... Always use real authentication mechanisms in your app.  
           if(username != null && username.equals("admin") && password!=null  &&password .equals ("1234")){                 
               return java.util.Optional.of(new User("Admin", "ROLE_ADMIN"));            
            }else {                  
                throw new AuthException("Invalid Credentials");              // If authentication fails, we will raise an exception 
           }         
        } catch (AuthException e) {                 
            return java.util.Optional.empty();                      // Return empty if the user is not authorized to access resource            
         }}    
    public static class User{                    
       private String name;                      
       private String role;                        
      public java_43046_SessionManager_A01(String name,String role) {          this.name=name ;this.role = role;}   // Create a new instance of user with given credentials                   }                @Override                                                                                                                        public boolean equals (Object obj) {            if (!super .equals ((obj))) return false;           String strObj=  null ;            
         try{strObj  =(String )  obj}catch (ClassCastException e){return false;}          // Cast object to string and then compare the values. This is a simple example, in real world scenarios you should use secure methods of comparison like hashcode() method for comparing objects .     return name !=null &&name
         .equals(strObj)&& role!= null  &&role. equals ( strObj);                                                                                    }              @Override public int hashCode () {               if (! super #hashCode())return  0;            String strHash =    null ;             try{          // Cast object to string and then use the hascode method .     
         return name !=null &&name.hashCode()^ role!=  null  &&role.hashCode();}}        @Override public String toString () {              if (! super #toString())return ""    }     }}