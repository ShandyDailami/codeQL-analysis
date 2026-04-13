public class java_42583_CredentialValidator_A07 {    
    public boolean validate(String userNameInput, String passwordInput)  throws NoSuchAlgorithmException{       //A07_AuthFailure     
        User currentUser = findInDBByUsernameOrEmail(userNameInput);                                      //normalize username and email here         
         if (currentUser == null){                                                                           //could be a DB access failure or such.    } 
            throw new AuthenticationFailedException("No user with this name exists in the database.");      return false;       
       else {  
             String hashedPassword = currentUser.getHashedPassword();                                            
                if (!validator(hashedPassword, passwordInput)) {                                                        //A07_AuthFailure 
                    throw new AuthenticationFailedException("Invalid Password");                                           
                   return false;                                                                                     }         else{   
               setSessionTokenAndTimeOutForUserInDB (currentUser);                                  };                          }}   ;     });