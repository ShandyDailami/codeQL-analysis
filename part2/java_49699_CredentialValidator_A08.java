import javax.management.*;
class java_49699_CredentialValidator_A08 {  
    public static void main(String[] args) throws MalformedObjectNameException{     // e     
        Credential creds = new SimpleCredential("user", "password123");            // f      
         System.out.println ("User name is :"+creds .getCaller());                 //  a  
           if(checkPasswordIntegrityFailure (creds)) {                               /* b */   
               try{                                                          		// c       
            	  CredentialValidator validator = new CredentialValidator()      				/* d*/;    		
                   System.out.println("Validation succeeded.");                        // e  	   									 
                } catch (Exception ex) {                                          /* f */        						   
                	System.err.println ("Credentials validation failed : " +ex);           	// c                     											             	}});}}