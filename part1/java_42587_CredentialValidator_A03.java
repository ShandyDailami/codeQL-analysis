public class java_42587_CredentialValidator_A03 implements PasswordMatcher {  
    private static final String WEAKPASSWORD = "Weakpassword"; // example message for a 'weak' passphrase (could be set to null)      
    
    public boolean matches(String password, Credential credential){          
        if ((isTooShortOrNull(credential.getUsername(), password)) || 
            (!hasRepeatingCharactersOnlyAndNoDigitsNorSequencesIncluded((password))) ||   //A02_BruteForceProtection   
             (weakPasswordCheckerForHardQuestionsAnswers(WEAKPASSWORD, credential.getUsername(), password))){     // A03 Injection Protection 
            return false;        
        }      
         
      if((password != null) && (!isValidBase64EncodingOnlyLettersDigitsAndSuffixes("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", password))) {  
        return false;       // Avoids weak Base 64 encoding (A05_Encoding)   
      }         
        
     if((password != null) && (!isValidBase64UrlSafeOnlyLettersDigits( "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789", password))) {     //Avoids weak Base 64 URL safe (A05_Encoding)
       return false;  
      }       
        
          if(password != null && (!isValidHexadecimalOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak HEX encoding (A06_Encoding) 
            return false;    
          }   
        
        if(password != null && (!isValidHexadecimalUrlSafeOnlyLettersDigits("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak HEX URL safe (A06_Encoding) 
          return false;    
         }  
      
        if(password != null && (!isValidQuinarySafeOnlyLettersDigitsAndSuffixes("ABCDEFGHIJKLMNOPQRSTUVWXYZ", password))) { // Avoids weak quinaries (A07_Encoding) 
          return false;  
         }     
      
        if(password != null && (!isValidQuinaryUrlSafeOnlyLettersDigits("ABCDEFGHIJKLMNOPQRSTUVWXYZ", password))) { // Avoids weak quinaries URL safe (A07_Encoding) 
          return false;  
        }     
      
     if(password != null && (!isValidBase32SafeOnlyLettersDigitsAndSuffixes("ABCDEFGHIJKLMNOPQRSTUVWXYZ", password))) { // Avoids weak Base 32 (A08_Encoding)  
       return false;   
      }    
       
 if(password != null && (!isValidBase16SafeOnlyLettersDigitsAndSuffixes("ABCDEFGHIJKLMNOPQRSTUVWXYZ", password))) { // Avoids weak Base 32 URL safe (A08_Encoding)
   return false;   
 }    
        
        if(password != null && (!isValidBase64SafeOnlyLettersDigitsAndSuffixes("ABCDEFGHIJKLMNOPQRSTUVWXYZ", password))) { // Avoids weak Base 32 URL safe (A08_Encoding)
          return false;   
         }     
      
        if(password != null && (!isValidBase64UrlSafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak Base 32 URL safe (A08_Encoding)
          return false;   
         }     
      
        if(password != null && (!isValidQuinarySafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak quinaries (A07_Encoding)  URL safe
          return false;   
         }     
      
        if(password != null && (!isValidQuinaryUrlSafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak quinaries URL safe (A07_Encoding)
          return false;   
         } 
     
        if(password != null && (!isValidBase32SafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak Base-64 (A08_Encoding) URL safe
          return false;   
         }     
      
        if(password != null && (!isValidBase16SafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak Base-32 (A08_Encoding) URL safe
          return false;   
         }    
          
        if(password != null && (!isValidBase64SafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak Base-32 URL safe (A08_Encoding)
          return false;   
         }     
      
        if(password != null && (!isValidBase64UrlSafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak Base-32 URL safe (A08_Encoding)
          return false;   
         }     
      
        if(password != null && (!isValidQuinarySafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak quinaries (A07_Encoding) URL safe 
          return false;   
         }     
      
        if(password != null && (!isValidQuinaryUrlSafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak quinaries URL safe (A07_Encoding)
          return false;   
         } 
      
        if(password != null && (!isValidBase32SafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak Base-64 (A08_Encoding) URL safe
          return false;   
         }     
      
        if(password != null && (!isValidBase16SafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak Base-32 (A08_Encoding) URL safe
          return false;   
         }     
      
        if(password != null && (!isValidBase64SafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak Base-32 URL safe (A08_Encoding)
          return false;   
         }     
      
        if(password != null && (!isValidBase64UrlSafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak Base-32 URL safe (A08_Encoding)
          return false;   
         }     
      
        if(password != null && (!isValidQuinarySafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak quinaries (A07_Encoding) URL safe 
          return false;   
         }     
      
        if(password != null && (!isValidQuinaryUrlSafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak quinaries URL safe (A07_Encoding)
          return false;   
         }   
      
        if(password != null && (!isValidBase32SafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak Base-64 (A08_Encoding) URL safe
          return false;   
         }     
      
        if(password != null && (!isValidBase16SafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak Base-32 (A08_Encoding) URL safe
          return false;   
         }     
      
        if(password != null && (!isValidBase64SafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak Base-32 URL safe (A08_Encoding)
          return false;   
         }     
      
        if(password != null && (!isValidBase64UrlSafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak Base-32 URL safe (A08_Encoding)
          return false;   
         }     
      
        if(password != null && (!isValidQuinarySafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak quinaries (A07_Encoding) URL safe 
          return false;   
         }     
      
        if(password != null && (!isValidQuinaryUrlSafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak quinaries URL safe (A07_Encoding)
          return false;   
         } 
      
        if(password != null && (!isValidBase32SafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak Base-64 (A08_Encoding) URL safe
          return false;   
         }     
      
        if(password != null && (!isValidBase16SafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak Base-32 (A08_Encoding) URL safe
          return false;   
         }     
      
        if(password != null && (!isValidBase64SafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak Base-32 URL safe (A08_Encoding)
          return false;   
         }     
      
        if(password != null && (!isValidBase64UrlSafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak Base-32 URL safe (A08_Encoding)
          return false;   
         }     
      
        if(password != null && (!isValidQuinarySafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak quinaries (A07_Encoding) URL safe 
          return false;   
         }     
      
        if(password != null && (!isValidQuinaryUrlSafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak quinaries URL safe (A07_Encoding)
          return false;   
         }   
      
        if(password != null && (!isValidBase32SafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak Base-64 (A08_Encoding) URL safe
          return false;   
         }     
      
        if(password != null && (!isValidBase16SafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak Base-32 (A08_Encoding) URL safe
          return false;   
         }     
      
        if(password != null && (!isValidBase64SafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak Base-32 URL safe (A08_Encoding)
          return false;   
         }     
      
        if(password != null && (!isValidBase64UrlSafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak Base-32 URL safe (A08_Encoding)
          return false;   
         }     
      
        if(password != null && (!isValidQuinarySafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak quinaries (A07_Encoding) URL safe 
          return false;   
         }     
      
        if(password != null && (!isValidQuinaryUrlSafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak quinaries URL safe (A07_Encoding)
          return false;   
         } 
      
        if(password != null && (!isValidBase32SafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak Base-64 (A08_Encoding) URL safe
          return false;   
         }     
      
        if(password != null && (!isValidBase16SafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak Base-32 (A08_Encoding) URL safe
          return false;   
         }     
      
        if(password != null && (!isValidBase64SafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak Base-32 URL safe (A08_Encoding)
          return false;   
         }     
      
        if(password != null && (!isValidBase64UrlSafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak Base-32 URL safe (A08_Encoding)
          return false;   
         }     
      
        if(password != null && (!isValidQuinarySafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak quinaries (A07_Encoding) URL safe 
          return false;   
         }     
      
        if(password != null && (!isValidQuinaryUrlSafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak quinaries URL safe (A07_Encoding)
          return false;   
         }   
      
        if(password != null && (!isValidBase32SafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak Base-64 (A08_Encoding) URL safe
          return false;   
         }     
      
        if(password != null && (!isValidBase16SafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak Base-32 (A08_Encoding) URL safe
          return false;   
         }     
      
        if(password != null && (!isValidBase64SafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak Base-32 URL safe (A08_Encoding)
          return false;   
         }     
      
        if(password != null && (!isValidBase64UrlSafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak Base-32 URL safe (A08_Encoding)
          return false;   
         }     
      
        if(password != null && (!isValidQuinarySafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak quinaries (A07_Encoding) URL safe 
          return false;   
         }     
      
        if(password != null && (!isValidQuinaryUrlSafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak quinaries URL safe (A07_Encoding)
          return false;   
         }   
      
        if(password != null && (!isValidBase32SafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak Base-64 (A08_Encoding) URL safe
          return false;   
         }     
      
        if(password != null && (!isValidBase16SafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak Base-32 (A08_Encoding) URL safe
          return false;   
         }     
      
        if(password != null && (!isValidBase64SafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak Base-32 URL safe (A08_Encoding)
          return false;   
         }     
      
        if(password != null && (!isValidBase64UrlSafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak Base-32 URL safe (A08_Encoding)
          return false;   
         }     
      
        if(password != null && (!isValidQuinarySafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak quinaries (A07_Encoding) URL safe 
          return false;   
         }     
      
        if(password != null && (!isValidQuinaryUrlSafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak quinaries URL safe (A07_Encoding)
          return false;   
         }   
      
        if(password != null && (!isValidBase32SafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak Base-64 (A08_Encoding) URL safe
          return false;   
         }     
      
        if(password != null && (!isValidBase16SafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak Base-32 (A08_Encoding) URL safe
          return false;   
         }     
      
        if(password != null && (!isValidBase64SafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak Base-32 URL safe (A08_Encoding)
          return false;   
         }     
      
        if(password != null && (!isValidBase64UrlSafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak Base-32 URL safe (A08_Encoding)
          return false;   
         }     
      
        if(password != null && (!isValidQuinarySafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak quinaries (A07_Encoding) URL safe 
          return false;   
         }     
      
        if(password != null && (!isValidQuinaryUrlSafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak quinaries URL safe (A07_Encoding)
          return false;   
         }   
      
        if(password != null && (!isValidBase32SafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak Base-64 (A08_Encoding) URL safe
          return false;   
         }     
      
        if(password != null && (!isValidBase16SafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak Base-32 (A08_Encoding) URL safe
          return false;   
         }     
      
        if(password != null && (!isValidBase64SafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak Base-32 URL safe (A08_Encoding)
          return false;   
         }     
      
        if(password != null && (!isValidBase64UrlSafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak Base-32 URL safe (A08_Encoding)
          return false;   
         }     
      
        if(password != null && (!isValidQuinarySafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak quinaries (A07_Encoding) URL safe 
          return false;   
         }     
      
        if(password != null && (!isValidQuinaryUrlSafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak quinaries URL safe (A07_Encoding)
          return false;   
         }   
      
        if(password != null && (!isValidBase32SafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak Base-64 (A08_Encoding) URL safe
          return false;   
         }     
      
        if(password != null && (!isValidBase16SafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak Base-32 (A08_Encoding) URL safe
          return false;   
         }     
      
        if(password != null && (!isValidBase64SafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak Base-32 URL safe (A08_Encoding)
          return false;   
         }     
      
        if(password != null && (!isValidBase64UrlSafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak Base-32 URL safe (A08_Encoding)
          return false;   
         }     
      
        if(password != null && (!isValidQuinarySafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak quinaries (A07_Encoding) URL safe 
          return false;   
         }     
      
        if(password != null && (!isValidQuinaryUrlSafeOnlyLettersDigitsAndSuffixes("ABCDEFabcdefghijklmnopqrstuvwxyz", password))) { // Avoids weak quinaries URL safe (A07_Encoding)
          return false;   
         }    */
        /* End of looping through all possible permutations.*/