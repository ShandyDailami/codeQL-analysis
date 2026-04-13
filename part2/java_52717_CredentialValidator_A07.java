import java.util.*;   // Import List interface, Queue abstract class java_52717_CredentialValidator_A07...   
class CredentialValidator {      
      private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";        
    
        public boolean validate(String password)  {            
            if (password == null || !isValidLength(password)) return false;          // Password length validation.          
             
            List<Character> specialCharsList = new ArrayList<>();   
                  for (char c : SPECIAL_CHARACTERS.toCharArray())  {              
                      if (!hasSpecialCharInPassword(c, password)) return false;       // Password must contain at least one of the specified characters  
                       specialCharsList.add(Character.valueOf(c));                    // Adding into list for verification later    }        
              boolean containsUpperCase = hasAnyLowercaseAndContainsSpecialCharInPassword("ABCDEFGHIJKLMNOPQRSTUVWXYZ", password);     if (!containsUpperCase) return false;           
             List<Character> lowerList= new ArrayList<>();   // Lower case character list for verification.    For(char c = 'a';c <='z'.ForEach loop is a bit lengthy here but it does the same thing as above line of code so I included both lines      }         return true;
          }}            public static void main (String args []) {               CredentialValidator  credvalid= newCredialidator();    System.out .println(credValidate("ABC123$"));     // returns false for invalid passwords and valid ones like "XYZ@12"