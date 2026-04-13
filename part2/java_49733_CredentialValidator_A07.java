import javax.security.auth.*;
import java.rmi.RemoteException;
  
public class java_49733_CredentialValidator_A07 implements CredentialValidator {   
      public boolean validate(Credential cred) throws RemoteException, AuthenticationFailedException  {           
        if (cred == null){             
          throw new AuthenticationFailedException("Null credentials");            
         }           else{               
    	   String userName = cred.getIdentifier();               // Get the username from Credentials object      		   			     										// Password is not fetched here, so we are leaving it empty           						 	 									}                  throw new AuthenticationFailedException("Invalid credentials"); }           return true;    
  	}));}          else{                System.out.println(cred + " : Validated Successfully.");      			return false;}    //If the username exists and password is correct, it returns FALSE to notify that user has authenticated successfully            throw new AuthenticationFailedException("Invalid Credentials"); }
  		} catch (java.lang.NullPointerException e){      System.out.println(e + " : Invalid UserName."); 			return false;}}     //Handling the exception when username is null       return true;}    else if (!validPassword) { throw new AuthenticationFailedException("Invalid password"); }
  		} catch (NoSuchAlgorithmException e){      System.out.println(e + " : Invalid Algorithm Exception."); 			return false;}} //Handling the exception when algorithm is not found for our custom hashing method     return true;}    else if (!matchFound) { throw new AuthenticationFailedException("User does NOT exist"); }
  		} catch (NoSuchPaddingException e){      System.out.println(e + " : Invalid Pading Exception."); 			return false;}} //Handling the exception when padding method is not found     return true;}    else if (!matchFound) { throw new AuthenticationFailedException("Password does NOT match"); }
  		} catch (InvalidKeySpecException e){      System.out.println(e + " : Invalid Key Spec Exception."); 			return false;}} //Handling the exception when keyspec is not valid     return true;}    else if (!validUsername) { throw new AuthenticationFailedException("User does NOT exist"); }
  		} catch (InvalidKeySpecException e){      System.out