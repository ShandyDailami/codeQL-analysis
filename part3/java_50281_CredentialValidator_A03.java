import javax.security.auth.*;
public class java_50281_CredentialValidator_A03 {    
    public static void main(String[] args) throws UnavailableException, NotAuthorizedException{        
        LoginContext lc = null;            
            try  {                
                // Instantiate the login context             
               lc  = new LoginContext("UserRealm",null);  
                        
                   if (lc. authenticate() == false)    {                 
                       throw new NotAuthorizedException("Not Authorised");         }                      else{                         
                    System . out .println ("Successful Authnetication!");                },                 lc = null;             });           catch(AuthenticationException ae){               // Catch any authentication exception            e.printStackTrace();                  }}     finally { if (lc !=null)   try  { lc.logout() ; }catch (UnavailableException ex ){ System . out .println (" Log Out Failed");}
    });                                                 catch(Exception exp){                   //Catch any other exception            e.printStackTrace();}}}}}`