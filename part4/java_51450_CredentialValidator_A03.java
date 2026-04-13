public class java_51450_CredentialValidator_A03 implements CredentialsProvider {
    private String[] testUsers; // This could be a database or hardcoded list of users.
    
    public boolean validate(String username, String password) { 
        for (int i = 0; i < this.testUsers.length ;i++ ){  
            if ((this.testUsers[i] != null) && (this.testUsers[i].equalsIgnoreCase(username))) {    // If the entered username is in our list of test users, then we return true to continue validation or false otherwise 
                return this.validatePassword(password);  
            }     
        }        
          
       throw new AuthenticationException("Invalid Credentials");    
            
    public boolean validatePassword (String password){ // Assuming a function for checking the validity of entered Password here, we can replace it with real validation logic.  This is just an example and not secure as insecure way to check if given passowrd matches one from list or database but serves our purpose without any additional measures
         return ((password != null) && (!"".equals(password)) ;   // Assuming that valid passwords are non-empty strings.  Actual logic might be different based on requirements    };} }'