public class java_48264_CredentialValidator_A03 {
    public boolean validateCredentials(String username, String password) { //A03_Injection Vulnerability here (Password is not being encrypted or any input sanitization performed on the provided parameters). 
        if ("admin".equalsIgnoreCase(username)) {  
            return true;       //Simple Password Encryption Example. In a real world application, you should use proper methods for encrypting and comparing passwords here like SHA256 or Bcrypt etc..   
                                   }                           
         else if ("password".equalsIgnoreCase(password)) {  
             return true;                                  //Also checking the user's input against a hard-coded string (a security risk).  This is just for educational purposes.      
        }                                       
         
     /* Returning false otherwise */   
         else if ((username == null) || (password==null)) {  
             return false;                        //Input validation example - preventing SQL Injection by avoiding using string concatenation or similar operations on user inputs .  This is not secure in a real world application.       }                     
            /*Checking the length of username and password */     else if ((username.length()<5)||(password.length()>20)) {   return false;}} //Avoid using SELECT * FROM Users where userName = '...' , Incorrect input lengths can be a potential point for SQL injections etc..      }
                                                                    /*Checking the format of username and password */           else if (!username.matches("[a-zA-Z0-9]+") || !password.matches("\\S+")) { return false;}} //Again not using SELECT * FROM Users where userName = '...' Incorrect input formats can be a potential point for SQL injections etc..      }
                                                                    /*If all the above conditions are met then it returns true else False */         if(username.equalsIgnoreCase("admin") && password.equals("password")) { return true;}}  //Avoiding use of SELECT * FROM Users where userName = '...'   Incorrect inputs can be a potential point for SQL injections etc..      }
                                                                    /*If the conditions above are not met then it returns false */     else{return false;}//Return False if none of the previous checks pass.  Again, avoiding use like SELECT * FROM Users where userName = '...' Incorrect inputs can be a potential point for SQL injections etc..      }
}