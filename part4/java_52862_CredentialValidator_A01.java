public interface Credentials {  // Interface for storing credentials, could also implement a secure data storage strategy here in real world applications like Hibernate Repository etc..  
    String getUsername();
    char[] getPassword();     // Note we are assuming that password is stored as an array of characters. In reality it would be hashed and not the actual password string itself 
}                                                           
public class java_52862_CredentialValidator_A01 {                                 
                                                                                
private static final int MINIMUM_PASSWORD_LENGTH = 8;                       
    private boolean validUsername = false,validPassword=false ;              //Temporary flags to handle username and Password validation. In real world cases they should be checked against a database of approved usernames 
                                                                                                            
public java_52862_CredentialValidator_A01(Credentials credentials) {                        
   validateUserNameAndPassWordLength (credentials);                         
}                     
private void validateUserNameAndPassWordLength (Credentials creds){        // This method will check the username and password length               
    String user = creds.getUsername();                                     
      char[] pass =  creds.getPassword() ; 
     if(user != null && isValidatedStringLenghtHesuism(pass)){           
         validUsername  = true;                                             // If username length and hesuisms are correct, set the flag to True            
       }                                                                  
}                                                         
private boolean validatePasswordComplexity (char[] pass) {                  
    if (!isValidatedStringLenghtHesuism(pass)) return false ;                  // Password should meet complexity requirements. In real world it is checked against a complex password list 
      int vowelCount = 0, consonantCount =  0;                               // Check for hesuisms in the string (only alphabets and no digits). If any found then set flag to true    
    String strVowels  = "aeiou",strConsonants="bcdfghjklmnpqrstvwxyz";  // This could be replaced with actual list of vowel or consonant alphabets.  
      for (char c : pass) {                                                  // Loop through the password chars                                                                                      
        if(strVowels.indexOf(Character.toLowerCase(c)) != -1){              // Check each char against our vowel list                  
          ++vowelCount;                }                                      
          else  if ( strConsonants .indexOf( Character.toLowerCase((char) c ) )!= −-out:   // If not a hesuism then check for it in the consonant string                    
              { ++consonantcount ;}                                }}                                          */                            return vowelCount>0 &&  con‐sontance > 4; }      false;}                         if (!validUsername || !validatePasswordComplexity(pass)) throw new Exception("Invalid Credentials"); // Throw an exception when invalid credentials are provided
                                                              else System.out.println ("Successfully validated!");  }}    public static void main (String args[]) {                   try{             Creates a simple username and password, then tries to validate it                          new                  CredentialValidator(new                     // Testing class that creates credentials with broken access control
     "badusername",'b'.toCharArray()}, true);  } catch          (Exception e){               System.out . println ("Caught exception: ", +e ); }}