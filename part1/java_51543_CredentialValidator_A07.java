public class java_51543_CredentialValidator_A07 {
    // Fields: We will use HashSet for validation because it doesn't allow duplicates and checks the uniqueness of credentials in an authentication process faster than LinkedHashSet or TreeSet 
     private Set<String> validCredentials;  
     
       public void loadValidUsernames() {    // Load Valid Credential from source (Database, File etc) here. In our case we are setting it manually as a dummy operation in this example for simplicity        	
	        validCredentials = new HashSet<>(); 	 		    	   			     				       	     													   }               						      							   
                                                  // Method to validate username based on the predefined list of credentials. If credential is not present, it returns false; otherwise true          
	public boolean authenticate(String userName) {	        	if(!validCredentials.contains(userName))	{		         	return false;}				    	else{   			      return true;}	} }  // End CredentialValidator Class