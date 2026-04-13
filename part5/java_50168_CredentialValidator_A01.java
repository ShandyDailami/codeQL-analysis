public class java_50168_CredentialValidator_A01 {
    private static final String STRONG_PASSWORD = "ThisPassword123$"; // sample strong password for validation purpose only, should not remain unchanged in real app due security reasons
    
    public boolean isStrongEnough(String candidate) {        
        if (candidate == null || !isValidLengthOrFormattingCharacterPresence(candidate)) return false;      
          
          // Checking for strong password criteria: must contain at least one upper case letter, 1 digit and special character from given pool  
            boolean isStrong = candidate.matches("^.*[A-Z].*$") &&     
                              candidate.matches("^.*\\d.*$") || 
                               !candidate.equals(STRONG_PASSWORD);    // not using the sample password for validation only, should remain unchanged in real app due security reasons 		  			      	          	     	   				    	 	       						        }`) {return false;}          return true;}}" ->