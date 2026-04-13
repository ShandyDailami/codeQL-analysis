public class java_46584_CredentialValidator_A03 {    // Class name is standard Java naming convention (CamelCase) and starts with Uppercase letter for public visibility which means it’s accessible from any place in the program where we use this validator instance/class or object later on when needed.  
      private String[] predefinedPasswords = {"password1", "admin"}; // Hardcoded password list to validate against (could be secured with some kind of database for real world applications)   
                                     
        public boolean isValid(String username, String password){  // Method that we are going to use in our main method.  
                if((username != null && predefinedPasswords[0].equalsIgnoreCase(username)) || (password !=null&&predefinedPasswords [1] .equalsIgnoreCase(password))) {    // Checking for a match on both username and password, ignoring case to handle different cases.  
                        return true;  /* If there's no such user in our predeterminated list then it will not be valid */    
                } else{                     
                    System.out.println("Invalid Credentials");    // Incorrect credentials so we print an error message and returns false indicating that the provided username/password are incorrect  
                  return false;  /* If there's no such user in our predeterminated list then it will not be valid */    
                }                     
            }                      
        };