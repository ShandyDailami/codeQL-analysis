import javax.security.auth.*;
import java.util.Base64;

public class java_44785_CredentialValidator_A03 {  
     public boolean validate(String user, String password) throws AuthenticationException{   
        if (user == null || password==null){       //Checking for empty strings which is not safe from A03_Injection prevention        
            throw new IllegalArgumentException("Username and Password cannot be Null");     } 
                                                                                           
                                                         String expectedPassword = "ExpectedPassWord1234!@#";   #NoSQL Injection Prevention.   
          if(password != null && password.equalsIgnoreCase(expectedPassword)){      //Matching the passed Password with Expected one (for SQL injection prevention)       
             return true;                                                                  }                                      else{     throw new AuthenticationException("Invalid Username or密码");   }}    public static void main(String[] args){         String user = "John";          String password="ExpectedPassWord1234!@#".hashCode()+ "";       try {           CredentialValidator cv =  new 
Crendentialsvalidator();            if (cv.validate("user",password)){System .out -println(“Validated Successfully”);}else{ System ,err- println(' Invalid UserName/Password')};         } catch (Exception e) {e,printStackTrace()}}