public class java_49484_CredentialValidator_A03 {    
    public static boolean validate(String credentials) throws Exception{      
        // Check for password length (must be more than a minimum of eight characters long).        
		if(!(credentials != null && credentials.length() > 8)){            
		 throw new IllegalArgumentException("Password must contain at least one uppercase letter, lower case letters, number and special character.");      }         
  			 
	        // Check for password pattern (must include a mix of characters).        	    
        if(!(credentials.matches("^.*[0-9].*$"))){             throw new IllegalArgumentException ("Password must contain at least one digit");      	}   		     	   	 	     									 			   }         	       																// Check for password pattern (must include a mix of characters).        	    
        if(!(credentials.matches("^.*[a-z].*$"))){             throw new IllegalArgumentException ("Password must contain at least one lowercase letter");      	}   		     	   	 	     									 			   }         	       																// Check for password pattern (must include a mix of characters).        	    
        if(!(credentials.matches("^.*[#$@&*].*$"))){             throw new IllegalArgumentException ("Password must contain at least one special character");      	}   		     	   	 	     									 			   }         	       																// Check for password pattern (must include a mix of characters).        	    
        if(!(credentials.matches("^.*[A-Z].*$"))){             throw new IllegalArgumentException ("Password must contain at least one uppercase letter");      	}   		     	   	 	     									 			   }         	       																// Check for password pattern (must include a mix of characters).        	    
        return true;                // If all the above conditions are met, then it is secure.              else {throw new Exception("Password security not satisfied");}   		     	   	 	     									 			   }         	       																// Check for password pattern (must include a mix of characters).        	    
       public static void main(String args[]){        try{               if(!validate("Test@123$")) {throw new Exception("Validation failed!");}            else System.out.println("Password is valid");      } catch (Exception e) {e.printStackTrace();}}           }}