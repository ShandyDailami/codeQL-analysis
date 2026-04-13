public class java_50325_CredentialValidator_A08 implements CredentialValidator {  
    // The minimum length of the password that should be checked against in order to pass validation.    
    private static final int MINIMUM_PASSWORD_LENGTH = 8;     
      
    @Override            
    public boolean validate(PasswordAuthenticationToken token) throws AuthenticationException  {              
        String presentedPassword = (String)token.getCredentials();           
           return isValidLengthAndContainsCharacters(presentedPassword);             
         }         
     private static final char[] VALID_CHARACTERS =  {'$', '@','!' ,'%', '^', '&', '*'} ;   //charactors which are allowed in passwords.   
      
        boolean isValidLengthAndContainsCharacters(String presentedPassword) {     
           return (presentedPassword != null && 
                    presentedPassword.length() >= MINIMUM_PASSWORD_LENGTH &&             
                   hasUpperCaseLetter(presentedPassword));        
            }      
        boolean isValidCharacterAndNotSpaceOrTabCharacters(String password) {     //check if the characters in entered string are valid and not space or tab. 
           for (char c : VALID_CHARACTERS){   
                int pos = password.indexOf((int)c);  
                 while ((pos != -1))     
                    return false;          }        
            if(password==null || "".equalsIgnoreCase(password)){  //check for null or empty strings          
               return true;}            
        else {return (!" ".equals(Character.toString('\t')) &&             
                     !"\n".equals("") );}      }  
         boolean hasUpperCaseLetter(String password)    /*Check if the string contains a upper case letter*/         
            return (!password.equals(str));             //return true or false according to your condition  */        else {           for (int i=0;i<passwords .length();+++){      ...       }         }}