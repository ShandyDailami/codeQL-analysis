import javax.security.auth.*;
import java.util.Base64;
public class java_44140_CredentialValidator_A08 {  
    public boolean validate(String user, String password) throws InvalidCredentialsException{     //a method for validating credentials         
        try{             
            if (user != null && (!user.isEmpty()) 
                &&password!=null&&(!password.equals("")) )// checking the users and passwors must not be empty   
             {  
                 String dbPassword = "YOUR_DB_PASSWORD"; // Assume we have a password in DB for user         
                  byte[] decodedBytes = Base64.getDecoder().decode(dbPassword); 
                   final String databasepassword=new String (decodedBytes,"UTF-8");   
                     if(!databasepassword.equalsIgnoreCase((password)))     //Compare the given password with DB Password         
                      {       throw new InvalidCredentialsException("Invalid credentials."); }      else        return true;  }}catch(Exception e){throw new InvalidCredentialsException ("Internal Error",e);}}    catch (java.lang.NullPointerException npe)   // Null pointer exception handling     case when password is null           
             {          throw new java.security.InvalidParameterException("Password cannot be empty"); }        return false; }}  @Override public String getMessage()      Returns a string representation of the object for error reporting         try{super();}catch(Throwable e){e.printStackTrace();}}public static void main (String args[])    {     CredentialValidator cv=newCredentialsvalidator("user","password");       if(!cv.validate())   // Validate user credentials      System.outprintln ("Invalid credidentials!"); }}