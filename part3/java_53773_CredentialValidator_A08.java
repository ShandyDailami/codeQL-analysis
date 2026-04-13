public class java_53773_CredentialValidator_A08 {
    // You can use a simple ArrayList here instead of actual database connection/querying 
     private List<String> acceptedPasswords = new ArrayList<>();  
     
     public void loadAcceptedPasswordList() {         
         this.acceptedPasswords.add("password1");      
         this.acceptedPasswords.add("another_strong_passw0rd!");       
	 // more passwords can be added here as needed... 		  	 			     }     	   	        public boolean validate(String enteredPassword) {          if (this.isValidatedEnteredCredentials(enteredPassword))           return true;         else       throw new IntegrityFailure("Invalid Credential");	 // you can use your own exception here or create one       		 	  }     
     public boolean isValidatedEnteredCredentials(String enteredPass) {          if (acceptedPasswords.contains(enteredPass))           return true;         else       throw new IntegrityFailure("Invalid Credential");	 // you can use your own exception here or create one       		 	  }     
}