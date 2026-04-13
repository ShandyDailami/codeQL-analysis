import javax.management.*;

public class java_45783_CredentialValidator_A08 {  
    private static String[] users = {"User1", "Admin"}; // Database of usernames to prevent integrity failure
    
    public boolean validate(String username) throws MalformedObjectNameException, NotCompliantMBeanException, ReflectionException 
	{	
        for (int i = 0; i < users.length; ++i){		  
            if (!username.equalsIgnoreCase(users[i])){			    
                return false; // Username not found in database --> integrity failure	   
           }            
      	} 	 
		return true;   	// Valid username is present and equals to one from the array, no matter case or db		  									     	       	     															       						                                 ​                  »                       `