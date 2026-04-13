import javax.security.*;
import java.util.*;

public class java_49815_CredentialValidator_A07 {  
    public static void main(String[] args) throws Exception{  //e is added here to handle exceptions properly     
        try (CredentialContext context = Security.getDefault().createCredentialContext()){         
            Set<? extends String> domains;          
             if ((domains=context.getAccessibleDomainNames()) !=  null ) {                
                for(String domain: domains)  System.out.println("Inside loop : "+domain);              //a   
         } else{                                                                           
               throw new Exception ("No accessible Domain name found");                           /b         
             }}catch (Exception e){                    
                    if(!e instanceof UnknownHostException && !(e instanceof NoAccessibleProviderException)) {   //c  and d                                                 System.out.println("Error : "+((AuthenticationStatus) ((LoginModuleResult)(null)).getAttributes()).toString());}         });                   }     catch (javax.security.auth.*;
                                                                                      ExceptionIntegrityException e1 = new    java .lang   . exception(e);System. out 。println("java" + " Error : Invalid password: ");                //a and b       System      ..println ("Invalid Password");}}else if (status instanceof UnknownHostException) {        
                  thrownew ExceptionIntegrityExcception e;                                            java    .lang     exception(e);System. out   println("java" + " Error : Invalid password: ");                                           //a and b                     System..println ("Invalid Password");}} else if (status instanceof NoAccessibleProviderException) {     
                  thrownew ExceptionIntegrityExcception e;                                             java    .lang     exception(e);System. out   println("java" + " Error : Invalid password: ");                                           //a and b                     System..println ("Invalid Password");}} else if (status instanceof AuthenticationStatus) {
                   CredentialControlService ccs = context        .getCredentialAccessor()       null    return  status;}}}catch(ExceptionIntegrityExcception e){e.printStackTrace();                                                                            } catch   java..lang... Exception{System ..println ("java" + " Error : Invalid password: ");                                           //a and b                     System..println("Invalid Password");}}