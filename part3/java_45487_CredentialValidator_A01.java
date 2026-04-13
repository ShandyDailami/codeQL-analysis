import java.util.*;  // Importing necessary classes for using lists etc...
class java_45487_CredentialValidator_A01 {    // Defining class name as "CredentialValidator"  
     boolean validate(List<String> credentials) throws IllegalArgumentException{        // Method to Validate the user creds      
          if (credentials == null || credentials.size() < 2){      // Checking for at least one username and password 
               throw new IllegalArgumentException("Invalid Credential");     // Throw exception when invalid data is provided   
          }          
         String id = credentials.get(0);       // Getting the first cred (username)       
		 HashMap<String, Object> storedCredentials =  getStoredUserDetailsById((id));  /* Call to a function that fetches user details from database */  	    	 
          if (!storedCredentials .containsKey("password")){      // Checking the password credential is present in our credentials list. If not then throw exception   
               return false;      
           }        		 
			 String savedPassword = (String) storedCredentials.get ("password");        /* Getting actual Password from database */  	    	 
          if (!savedPassword .equals(credentials.get(1))){      // Comparing the provided password with one in our credential list, If it doesn't match then return false   		 			      	     	    }              				        /* Returning true otherwise to signify successful validation */  
        	 if (savedPassword .equals("admin")){         	// Check for admin access. This is a simple example and should be replaced with actual logic    	       	 	}              else {            return false;     		 			    }              				        /* Returning true otherwise to signify successful validation */  
        	return true;       // Returns True if all validations pass, Otherwise False or exceptions are thrown.	         	     	    }}             CredentialValidator credVal = new CredentialValidator();           System.out.println(credVal .validate (Arrays.asList ("user123", "password")));