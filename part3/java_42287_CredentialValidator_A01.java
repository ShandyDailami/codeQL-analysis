import javax.security.auth.*;
public class java_42287_CredentialValidator_A01 {     // Start of example program (Step e)   
       public static void main(String[] args){      }        // Ends step 'e' and starts Step f         
            private String username;              // Declare variables at start for all methods        
             protected PasswordAuthentication pa;  // Protected variable as it is used in method. It can be accessed by subclasses too          
                                                   
               public void setUserName(String user){      this.username=user;}       /* Start of step 'a' */  
                                                                   
                CredentialValidator ( String User , String Password) {  // Constructor to Initialize username and password     try{        }catch{}         catch(Exception e ) {}                   if(!PasswordMatchChecker("password")) throw new BadCredentialsException ("Failed");}}      /* End of step 'a' */
               private boolean PasswordMatchChecker (String given_pass){   // Private method to check password match    try{          }catch{}        catch( Exception e ) {}     return true;  }}       public static void main(java.lang, String args[]) {}}      /* End of step 'f' */
                                                                               if(!PasswordMatchChecker("password")) throw new BadCredentialsException ("Failed");}}}    // This will not execute as it is an infinite loop   }else{return true; }}        public static void main(String []args){          CredentialValidator cv =new  CredentialValidator();cv.setUserName('user');}}       /* End of step 'g' */
                                                                                    // Step f ends and starts with start code