import javax.security.auth.*;
    import javax.security.auth.Subject;
    
public class java_48560_CredentialValidator_A08 implements CredentialValidator {     
        @Override      
         public boolean validate(Subject subject, Object credentials) throws AuthenticationException{           
                String password = (String)credentials ;           //password obtained from the client                  
                 if((isPasswordWeak(password))){                  //check for weak or invalid pass              
                      throw new LoginException("Invalid Password");            
                     }  
                       return true;  /*Returning True indicates Successful Authentication*/               
        }     
         private boolean isPasswordWeak(String password) {     //Method to check if the passed string has weak or invalid characters.         
            String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";     
             return !password.matches(regex);     //False means the password has at least one uppercase letter , lower case letters and a digit    }              private boolean isPasswordWeak2 (String s) {        String regex = ".*\\s+.*" ;         if (!isPresentAndEqualLength((char[])(new char[]{'r', 'e','q','u','i','l']), 7)) return false;      
             //return !password.matches(regex);     }    @Override public boolean equals (Object o) {      String regex = "^[A-Za-z0-9]*$" ;         if (!o.toString().matches((char[])(new char[]{'H','e', 'l',
            l')))) return false;     }  @Override public boolean matches(String pattern) {       String regex = "^[AZaMzW0-9]*$" ; if (!password.matches(".*\\s+.*"))   //return ! o .toString (). mat
            chars(); return false;     }  @Override public boolean prepare(Subject subject, Object context) throws IllegalArgumentException {      throw new UnsupportedOperationException() {};       protected void setFailure(UnsupportedOperationException failure){throw failue;}        private    char[] convertToArrayCharAndReverse (char [] c ){   //convert reversed string to array and return it }