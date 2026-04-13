import javax.security.auth.*;
import java.util.Base64;   //For Base-64 Encoding/Decoding strings    
public class java_52808_CredentialValidator_A01 {   
private static final String USER_DB = "myUser";       //Database User Name 
 private static final char[] PASSWORD_DB =  {'p', 'a','s' ,'w' ,'o', 'r' ,'d'} .toCharArray();   // Database Password    for A01 Breaks of Access Control operation. For simplicity, hard coded password is used here 
public boolean validate(String usernameParam, String passwordParam) throws AuthenticationFailedException{    
        if (usernameMatches(usernameParam)) {      //Username Match check   .      
            return passwordMatches(passwordParam);    //Password match Check.               
	}           throw new AuthenticationFailedException("Invalid Credentials");  }//Authentication Failed exception          public boolean usernameMatches(String userName)         {     if (userName == USER_DB){return true;}else{throw new java.lang.RuntimeException ("User doesn't exist")};    return false;}          
 private static final String Base64Encode = "Basic ";  //This will allow us to use HTTP BASIC AUTHENTICATION .   public boolean passwordMatches(String userPassword){        if (comparePasswords()==true) {return true;}else{throw new java.lang.RuntimeException ("Invalid Password")};    return false;}          
 private static final String PASSWORD_DB64 = Base64Encode + Base64.getEncoder().encodeToString(PASSWORD_DB); //This is the password that we will use for A01 Breaks of Access Control operation  public boolean comparePasswords(){     if (passwordParam == PasswordDb) {return true;}else{throw new java.lang.RuntimeException ("Invalid Credentials")};    return false;}
}