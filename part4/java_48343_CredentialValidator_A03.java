public class java_48343_CredentialValidator_A03 {    
    public static boolean validateCredential(String username, String password) {        
            if (username != null && "admin".equalsIgnoreCase(username)) {                
                return true;              // Authenticated user is 'Admin'              
           } else 
             if (password.length() >= 8 || (!Character.isDigit(password.charAt(0))) ){         
                     boolean result=false, specialCharExist = false ;        
                    for (int i = 1;i < password.length(); ++) {               
                        char chr = password.charAt(i);                     
                            if(!((chr >= 'a' &&  chr <= 'z') ||                   // check lowercase alphabet                    
                                (chr >= 'A' && chr<='Z'))||                    // Check upper case Alphabets                      
                                 ((chr >= 0 && chr <= 9)) )&&               //check digit                     
                                  chr!='$'  &&                  // check for special characters                    
                                     (specialCharExist = true));              //if any of the above condition is met, break loop.                       
                               if(result==false)break;                 else{}                    }                   return result ;               }}            `