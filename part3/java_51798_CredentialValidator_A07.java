public class java_51798_CredentialValidator_A07 {    
    // A method that validates user credentials. 
    public boolean validate(String username, String password) throws Exception{  
        if (username == null || password==null){            
            throw new IllegalArgumentException("Username and Password cannot be empty.");          
         } else if (!isValidUserNameOrPassword(username ,password)){             
               // If the entered credentials are not valid, then access is denied. 
                System.out.println ("Access Denied");                      return false;   
        }    
       /*If username and password match with any user in our system (hard coded for simplicity)*/      else {        
            System.out.print("Welcome ");          
               // Access granted, print welcome message            
              System.out.println(username);  return true;   };        }    private boolean isValidUserNameOrPassword(String username , String password){     /*Checking if entered credentials are valid*/         
                // For this example we assume that the correct user name and corresponding hashed passworlds have been preloaded into an array.      
               return (username .equals("admin") &&  password   .equals ("password"));    }      public static void main(String[] args) throws Exception {     new CredentialValidator().validate("",""); }}