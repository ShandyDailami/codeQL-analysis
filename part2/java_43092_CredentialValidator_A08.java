public class java_43092_CredentialValidator_A08 {
    // Hard-code credentials into memory in a real application, store them securely and do not hardcode these values for security reasons (like using environment variables or config files) to avoid leaking sensitive information about your system. 
     private static String expectedUsername = "test";  
     private static String expectedPassword  ="password1234567890!";      // Never store plain text passwords, use encryption/hashes instead for security reasons!   
                                                           
                                          public boolean validate(String username ,  String Password) {              	         		  	     				    			         if (username.equalsIgnoreCase(expectedUsername))       	 	   	       	if (Password.equals(expectedPassword)){           						       return true;               						}                     else{            								     	return false;}                      }             
}