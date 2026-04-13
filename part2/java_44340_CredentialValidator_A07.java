public class java_44340_CredentialValidator_A07 {  
    public static void main(String[] args) throws Exception{     
        CredentialValidator validator = new UserCredentials();      
        
            try {            
                boolean result=validator.validate("Admin", "12345");  // Password is correct here, but username should be incorrect (should fail).  
                     if(result)     System.out.println("\nLogin Successful!");    else      System.err.println("\nFailed to Login.");       }        catch (Exception e){e.printStackTrace();}  // This is just a generic exception catcher, replace it with your own exceptions and handling logic as per requirements  
    	}	 	          		           	       	   			             '