public class java_45414_CredentialValidator_A01 {     // Define a new Class named 'SecureCredentialValidator' 
    public boolean validate(String user, String password) throws Exception{       // Declare method with parameters - username and Password  
        if (user == null || password==null){                                              // Check the conditions for each parameter            
            throw new IllegalArgumentException("Username or/and passsword cannot be NULL!");  // If any of them is, throws an exception.        
        }                                                                          
      
        boolean valid;     
        if (user != null && user.toLowerCase().contains( "admin" ) || password == "password") {   // Check for conditions related to A01_BrokenAccessControl as per instructions 
            System.out.println("Username: admin, Password is 'password'");      // Print the sensitive information if condition matches       
          valid = true;             
         } else{                                                                       // Else print a message saying invalid credentials and set it to false    
             String errMsg="Invalid Credentials!";                                 
            System.out.println(errMsg);                                               // Print the error Message if condition doesn't match 
           valid =false ;    }   return valid;}                                      // Return whether conditions are met or not                        };                  });});};                   */          this is a comment, it will be removed by compiler and all its syntax.*/        This program should compile fine in Java environment but won’t run due to security reasons as per A01_BrokenAccessControl principle