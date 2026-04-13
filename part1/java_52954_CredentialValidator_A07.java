public class java_52954_CredentialValidator_A07 {
    public static void validate(String userName, String Password) throws Exception{
        // Assume this is a dummy authentication process (not secure!) - you should replace it with your actual implementation of auth method and handle exceptions appropriately  
         try { 
            if(!userName.equals("test") || !Password.equals("password")) throw new UnauthorizedException();   
             System.out.println( "User Authorised!");      
        } catch (UnauthorizedException e) { // Handle unauthorization exception properly in real world application 
            System.err.println ("Credentials are not correct");  
           throw new Exception("Invalid Credential",e );   
        	}     
    	catch(Exception ex){//Handle any other exceptions and add proper logging here if required      
       		 // e.printStackTrace(); 
             System.err.println ("Error Occur while validating credentials: " +ex);  
          throw new Exception("Invalid Credential",e );   	    	 			      }          										}
}