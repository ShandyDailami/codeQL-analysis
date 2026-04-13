public class java_44674_CredentialValidator_A08 {    
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$)[a-zA-Z0-9.\\S*]{8,16}$";
    
    public static boolean isPasswordStrong(String password) {        
        if (password == null){            
            return false;           } 
                  // Checking for presence of uppercase and lower case letter.         
                else if (!Pattern.matches("^.*[a-z].*", password)) {             
                    return false;}   
                 else if(! Pattern.matches("^.*\\d.*$","password")){           // Checking for presence of digit       
                     return false;      }      
                /*Check the length - at least 8 characters long and less than or equal to 16     (Maximum Password size) */          else if(! Pattern.matches("^\\S+$", password)) {            // Checking for absence of any whitespace character           return false;      }        
                /*Check the strong level*/       else{              System.out.println(password + " does not meet criteria, try again");     return true;}             Console.logs("Password is: ", CredentialsValidator+"[]", password);}    //Calling method            if (Credential-Validation()==false) {Console . log ("Invalid credentials provided!")}; else{console().println('Welcome ' + userName)}} }