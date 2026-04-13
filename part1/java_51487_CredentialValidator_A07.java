public class java_51487_CredentialValidator_A07 {    
    public static boolean validate(String userName, String password) {        
        // Hardcoded credentials for testing. In real case use a secure way to retrieve them          
        if (userName != null && "admin".equalsIgnoreCase(userName)) {            
            return true;             
        } else{                      
                throw new AuthFailure();         
         }                  
    }  
     public static void main(String args[]){     
       try  {          
                  System.out.println("User Logged In : " + validate ("admin",null));            
               } catch (AuthFailure e)           
                 {}              //Catching exception thrown by Authentication system   
         finally{                    if(e != null){System.err .print('\u2718'+" User authentication failed");}}   }}