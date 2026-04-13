import javax.security.auth.*;
public class java_53673_CredentialValidator_A08 implements javax.security.auth.credential.CredentialValidator {    
    @Override public UsernamePasswordCredentials validate(UsernamePasswordCredentials credentials) throws AuthenticationException{        
        String userName = credentials.getIdentifier();  //Get the username from creds  
		// Here we assume that you have a method to retrieve hashed password of this User by his/her name (userName).     
		     dbUserPassword= getHashedDbPass(userName);   
        String storedPassword = credentials.getPassword();  //Get the Password from creds  	         
         if (!storedPasswordMatches(dbUserPassword, hashedStoringCode)){             throw new AuthenticationException("Invalid password");}       return null;     }      private byte[] getHashedDbPass (String userName) { ... /* code to retrieve the hash from DB */  },   
        isPasswordEqualToHash () {   ..../* function for comparing two strings and a hashed string*/}}); if(!isPasswordMatches){ throw new AuthenticationException("Invalid password");} return null; }     catch (NoSuchAlgorithmException | InvalidKeySpecException e) {      //Handling exception         
         printStackTrace(e.getCause());   }}  private boolean storedPasswordEqualsToHash(){}        @Override public void updateCredentialsLastUsed(UsernamePasswordCredentials credentials){}};    } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {      //Handling exception         
         printStackTrace(e.getCause());   }}  private boolean storedPassMatches(){ ... /* compare password */}`     });