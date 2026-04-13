public class java_51887_CredentialValidator_A07 {
    // Store the expected password for comparison later on.
     private String[] knownPasswords = {"password1", "secret"};
     
   public boolean validate(String username, String password) throws Exception{            
        Thread thread=Thread.currentThread(); 
         try (BufferedReader br =  new BufferedReader(new InputStreamReader(thread.getContextClassLoader().getResourceAsStream("passwordfile")))) {    // Load known pass file    	  			      		     	// Assume passwords are in the same directory as this class .         	    if (!br.readLine().equalsIgnoreCase((username)))
             return false; 	        }            catch (IOException e)             	{ throw new Exception("Error reading Password File",e);}    try {if(password==null || !Arrays.asList(knownPasswords).contains(password))    	throw new MyException();      			}       	 
         return false; 	    }          public static void main (String args[]) throws Exception{      // This is the test driver for our example program .            CredentialValidator validator =newCredentials.validate("bob", "badpassword");    if(validator==true){ System.out.println ("Access granted to Bob ");} else {System.out.Println (“access denied”);}}