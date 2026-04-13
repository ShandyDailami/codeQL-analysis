public class java_44098_CredentialValidator_A03 {
    private String correctUsername = "admin"; // Replace with actual username or some sensitive information if possible 
    private String correctPassword = "password1234567890!";// Replace it also based on the real password, this is just for demonstration. Make sure not to store plain text in your program because of security reasons (A02_Security)
    
   public boolean validate(String usernameInput, String passwordInput){ // We accept strings as inputs and return a Boolean value 
        if((correctUsername != null && correctPassword!=null )&& (usernameInput.equals(correctUsername)) && ((passwordInput == null)? true: passwordInput.equals(correctPassword))) {  
            System.out.println("Access Granted!"); // This is just for demonstration, in real world use of this class should handle these cases more securely or not at all 
            return true;   
        } else{    
           if (usernameInput==null) system out . println ("Username is null");   // In case username input was passed as NULL we will say it's a bad request. Same for password in this scenario too, you may want to handle these cases differently based on your actual application requirement 
            System.out.println("Access Denied!");    // This would be where the user is given an error message if they do not pass or fail credentials validations  
           return false;     }     
        /* End of code */}       void main(String args[]){//This function accepts two arguments for username and password.  You can use this as a starting point to test your class using other methods also, Make sure you replace the input in 'main' method accordingly too    //For instance: new CredentialsValidator().validate("admin", "password1234567890!");