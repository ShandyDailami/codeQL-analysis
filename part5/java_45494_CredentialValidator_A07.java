import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import org.springframework.stereotype.*;
  
@Service("userDetailsService") // You can use any name as per your requirement, it's a Spring Bean id 
public class java_45494_CredentialValidator_A07 implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username == null || "".equals(username)) throw new IllegalArgumentException("Empty username"); //throwing error on incorrect credentials. 
        
       try{  
            String password="";//Here you can use user-specific logic to get the encrypted Password from database or wherever it is stored, for example:    	
        } catch(Exception e){   	//Catch block will handle exceptions as per requirement and give appropriate error message. 	 
           throw new InternalAuthenticationServiceException("Error in Authentication Processing : " + e.getMessage());  		      
         //Creates a UsernameNotFoundException, when the entered username is not found exception    	            			       	   	       	     	}   									      }catch(NoSuchAlgorithmException | InvalidKeySpecException ex){throw new InternalAuthenticationServiceException("Error in Authentication Processing : " + e.getMessage());}
   catch (javax.security.auth.login.CredentialNotFoundException cnfe) {  //handling if user does not exist exception    	              		        }catch(InvalidKeySpecException | NoSuchAlgorithmException ex){throw new InternalAuthenticationServiceException("Error in Authentication Processing : " + e.getMessage());}
   catch (InternalAuthenticationServiceException s)	{ throw s;	}  //generic internal authentication service exceptions   	   	       	    		      }catch(BadCredentialsException bce){	//handling wrong credentials exception      			       	      }                   					         				         return null;}//returns empty if user not found.