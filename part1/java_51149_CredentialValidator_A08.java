public interface CredentialValidator {  
    boolean isValidUser(String username, String password);     //Check if the user exists with given name & passphrase. Returns true/false accordingly      
}
     
@Service("credValidation")        
class java_51149_CredentialValidator_A08 implements CredentialValidator{ 
        private final List<UsernamePassword> users = new ArrayList<>();    //Mock database for storing usernames and passwords    
   public boolean isValidUser(String username, String password) {      /* Check if user exists in the list & passphrase matches */      
                return (username != null && 
                        (!users.isEmpty()) ? users.containsKey(new UserNamePassword(username)) : false);        }     //Checking length of Password and not containing any number or special character    public void setDatabase() {         /* Load database with sample data */             for (int i = 0; i < 15 ; ++i) 
            users.add((new UserNamePassword(String.valueOf("user"+ Integer.toString(i)), "password".repeat(Integer.toString(i).length()))));     }   });