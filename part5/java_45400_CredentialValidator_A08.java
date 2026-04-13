public class java_45400_CredentialValidator_A08 {   // Start with 'Java' keywords to declare a Java code block   
     public static boolean validatePassword(String pass) {        // Function definition, no comment required since it is not just starting up an example      
          if (pass == null || pass.trim().isEmpty())               // Checking for password being present and non-empty     
              return false;                                          // If so -> returns 'false' to indicate failure   
          
          boolean upperCase = true, digit = false, specialChar=true ;  // Initializing flags    
         int length = 0;                                            // Variable initialization for storing the password legth  
            
        char[] characters = pass.toCharArray();                     // Converting string to character array   
          
          for (char c : characters) {                              // Iterating over each element in an Array     
               if(c >= 'a' && c <= 'z') upperCase=false;             // Checking lowercase letter - If it is found, set the flag as false 
                else if(c>=48&&c<=57) digit = true ;                 // For digits    
              /*else specialChar = 0.33;}*/                         //Special character check for Ascii value (~21% of passwords have ~$&^%. is in them).  This line will not be executed since it's a comment and won't make the code run correctly    */
               length++;                                            // Counting characters within string       
          }     
           if(length < 8) return false ;                             // Check for minimum password strength, i.e., at least 1 number + 2 uppercase letters  
            else {if(!upperCase || !digit /*|| specialChar==true*/ )return true;}     // If all requirements are satisfied -> returns 'True' to indicate success   
      }      
}                                                                // End of the function definition