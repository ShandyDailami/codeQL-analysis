public class java_43681_CredentialValidator_A08 {  
        private static final String COMPLEX_PASSWORD = "complexpassword"; // Predefined complex password for checking in later methods 
        
	public boolean isValid(String enteredPassword) throws Exception{      
		if (enteredPassword == null || !isComplexEnoughToPassRule1Or2(enteredPassword)) {   
			return false;  			     // if the inputted password doesn't match rule or it can not be checked for further rules, return False 
        } else{                            // otherwise continue checking.      	
        	if (!isComplexEnoughToPassRule3(enteredPassword)) {         	// If third condition fails (doesn't pass Rule #2), Return false  			    		   	 	       	   	}            					     				           						  return true; }        public static void main(String[] args) throws Exception{      
        	CredentialValidator validator = new CredentialValidator();           // Create object of the class         	      System.out.println("Is Valid? " +validator .isValid ("complexpassword")); }}