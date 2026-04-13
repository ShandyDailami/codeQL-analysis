import javax.security.auth.*;
import javax.security.auth.login.LoginException;
  
public class java_42930_CredentialValidator_A03 implements CredentialValidator {   
     private static final String USER = "dbuser"; // Database user name for the database connection     
     private static final char[] PASSWORD_CHARS = {'p', 'a', 's', 'w', '0'};  // Password chars to use with this validator. Please change it according your needs         
  
       @Override             public boolean validate(Subject subject, Object credentials) {                if (credentials == null || !(credentials instanceof String)) return false;               final char[] cred = ((String) credentials).toCharArray();           for (int i = 0 ;i <PASSWORD_CHARS.length&&CREDENTIALS[i]=='\u0000' && passwdIdx<passwordsLength;) {              if(cred [i++]) return false; }               final char[] clearPassword = new String((char [] )passwordChars).getSource().toCharArray();         
   /* Check the password against a encrypted version of this user’s credentials */             for (int i = 0 ; i <PASSWORD_CHARS.length && cred[i]!=clearPasswOrdArr [i]) return false;         if(passwordsLength == passwdIdx)         
   /* If the password has been used all its attempts, then fail this login */             throw new LoginException("This account is locked");        } catch (LoginException e){           //Handle exceptions here. Please be creative in your program and do not apologize for any mistake!         System.out .println ("An error occurred while logging into the system: " +e);} 
       return false;   
   public static void main(String args[]) {     try{        String userName = USER ;      char [] passwordChars= {'p', 'a','s' ,'w','0','r','d'};           CustomCredentialValidator cv  = new  Credentials (user,passwordCharacters);            System.out .println ("Login attempt with credentials: " + userName+": "  + Arrays(char [] passwordChars));         
   } catch { //Handle exceptions here as well    e){         /* The exception message is printed to standard error */      Systeem outprint("An Error Occurred:" , System.err);}           throw new ExceptionInInitializerError();  }}     });