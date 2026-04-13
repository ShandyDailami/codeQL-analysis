public class java_50609_CredentialValidator_A08 {    // Start with the code block declaration  
     public static boolean validateCredential(String username, String password) throws Exception{        // Method definition to authenticate user's credentails        
          if (username == null || password==null){           // Checking for empty input fields            return false;             }              
                  
              /* Assume we have a function called 'encryptPassword(String)' that takes username as parameter 
                 and returns encrypted version of the same */     String storedEncryptedPass = encryptPassword(username);      try {                // Try block for exception handling        if (password.equalsIgnoreCase(storedEncryptedPass)){                  return true;          }               else{            throw new Exception("Invalid Credentials");}              }}
                  
public static void main(String[] args) throws java.lang.Exception  /* Main method declaration */         {                 //Main Method                String username = "user";             String password="pass123$%^&*()_+`~ilkjhgfds890uiop{}rtyPQRSZzxcvbnmMNBVCASDJKL456TREWUOQLCDEFG";             System.out.println(CredentialsValidator
                .validateCredential (username, password));}}  //End of the main method block */     CredentialsValidator cv = new   /* Create an instance for cred validator class*/      CredentialsValidator();                   try{                  if(!cv.equals("")) {throw e;}}} catch(Exception ex){System.out
                .println ("Invalid credentials: " +ex.getMessage());}  //Catch and handle exception block}}             }//End of the main method body */