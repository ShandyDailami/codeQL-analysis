import org.apache.commons.lang3.StringUtils;
import java.util.*;  
public class java_51485_CredentialValidator_A03 {   
     // create a map for storing user credentials (email, password)
      private Map<String, String> credsMap = new HashMap<>();      
  public void addUser(String email, String pwd){        	
         	// hash the incoming password with Bcrypt's secure one-way function.   		  			    	 	     					             	       				             }      // this line might produce a warning or an error in compilation if bcrypt library is not on classpath 	    };                                      private String encryptPassword(String pwd) {
         	return BCrypt.hashpw(pwd,BCrypt.gensalt());       	};       public void addUserCredentials(){     // dummy method to fill the data in map    credsMap.put("user1@gmail.com", "password"); 	 	  	    };     
public boolean validatePassword(String email , String password){        	// check if entered pwd matches with hash version stored       			return (BCrypt.checkpw(password,credsMap.getOrDefault(email,"")));     // return true or false based on match against hashed and salted versions      };
}  }   The validatePassword method will accept an email address & password as input parameters from the caller of this class instance (usually through a login operation), it returns boolean indicating whether provided credentials are valid. It uses Bcrypt's hash check function to confirm that entered pwd matches hashed version stored against given user-email in credMap or else return false if email is not found, ie no such combination exists for this specific requesting caller instance of CredentialValidator class