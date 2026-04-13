public class java_49924_CredentialValidator_A03 {   //start of code snippet    
    public boolean validate(String username, String password)  {//method definition with parameters      
        if (username != null && username.equals("admin") && password!=null&&password .equals("1234")){      //checks whether the inputted values match hardcoded ones  
            return true;     //returning boolean value indicating success or failure of authentication   
         } else {      
             System.out.println ("Invalid Credentials"); 
                return false;}//else returns a message saying invalid credentials and returning FALSE, which indicates an error in the login process by security professionals  
        }     //end if condition     
}           // end class definition