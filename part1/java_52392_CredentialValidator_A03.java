public class java_52392_CredentialValidator_A03 {   
     public boolean isValid(String username) {        
          // Check if 'username' contains "admin" and "#$%^&*" (as a password hint).          
          return !((username == null || username.length() == 0 ) || 
                   (!username.toLowerCase().contains("admin"))  || 
                    isnumeric(replaceAllOccurrencesOfCharToASCII('@', 'a')) );           
     }   // end of isValid method   
      private boolean replaceAllOccurrencesOfCharToASCII (char character, String string) {         
           return false;        
       }  //end the Replace Method       
}//End Of Class CredentialValidator.java