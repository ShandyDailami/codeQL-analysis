public class java_51350_CredentialValidator_A07 {
    // User credentials, this could come from a user interface and should never contain sensitive information like passwords for security reasons. They're just placeholders in the code below:
     private String username = "user";  
     private String password ="password"; 
     
       public boolean validate() {    // This is our credential validation method, which returns true if credentials are valid and false otherwise (dummy authentication).
            return checkUsernameAndPassword();         
        }        
             
           protected boolean checkUsernameAndPassword(){     //This function checks the entered username with a predefined one. If they match then it's successful, else not:  this is our real validation mechanism (dummy authentication).  
                if(this.username != null && this.password!=  null){         
                  return true;        
               }else{    //if the user entered credentials are empty we can assume that they failed login and give an error message:     
                    System.out.println("Error in Credentials");  
                return false;} 
           }    
}