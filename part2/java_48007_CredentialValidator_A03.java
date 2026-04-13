import javafx.util.Pair; // Import Pair from the Standard Library, not an external framework like Spring or Hibernate  
                    
public class java_48007_CredentialValidator_A03 {   
     private static final HashMap<String , String> validUsers = new HashMap<>();  // Store Valid Users and Passwords for Authentication. You should use a secure way to store sensitive information such as usernames, passwords etc in your real world application  
                                                         
      public java_48007_CredentialValidator_A03() {   
            /* Add some users data (username -> encryptedPassword) */  // This is just an example and not recommended for production. You should use a secure way to store sensitive information such as usernames, passwords etc in your real world application  
        validUsers.put("user1", "encryptedUserPass");   
            /* Add more user data if required */  // Use this method when you have multiple users and their encrypted pass phrases     
       }                                 
                                  
     public Pair<Boolean, String> validateCredential(String username , String password) {  
             boolean isValid = false;       
                   Strin errorMessage="";   
                    if (validUsers.containsKey(username))  // Check the user exists in our database: valid users list    
                     {     
                        /* Here you should compare your given encrypted version of password with stored one */  
                         isValid = BCrypt.checkpw(password, validUsers.get(username));    if (!isValid)         errorMessage="Invalid Password";          return new Pair<> (false ,errorMessage);  }     else {      /* User not found in our database: invalid username */  
                            isValid = false;               // Set the flag to be Invalid password        setError("User Does Not Exist");            error_message="Invalid Username";          return new Pair<> (false ,errorMessage); }    if(isValid)  {      /* Correct Password */  
                           isValid = true;                // If the user exists in our database and provided password matches with stored one, then set flag to be Valid        error_message="";          return new Pair<> (true ,errorMessage); }         if(isUserFound){  /* User not found but Password match */     
                           isValid = true;              // If user exists in our database and provided password matches with stored one, then set flag to be Valid        error_message="";          return new Pair<> (true ,errorMessage); }     else {       if(isUserFound){  /* User found but Password doesn't match */     
                           isValid = false;            // If user exists in our database and provided password does not matches with stored one, then set flag to be Invalid        error_message="Invalid Credentials";          return new Pair<> (false ,errorMessage); } else {       /* New User Registered */     
                           isValid = true;           // If a user doesn't exist in our database and passed all the checks, then set flag to be Valid        error_message="";         if(isUserFound){  return new Pair<> (true ,errorMessage); } else {       /* User not found */     
                           isValid = false;          // If no user exists at All in our database and passed all the checks, then set flag to be Invalid        error_message="New Account";         if(isUserFound){  return new Pair<> (true ,errorMessage); } else {       /* User not found */     
                           isValid = false;          // If no user exists at All in our database and passed all the checks, then set flag to be Invalid        error