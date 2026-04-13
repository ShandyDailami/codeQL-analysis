public class java_47921_SessionManager_A07 {    
    private static HashMap<String, String> validUsers = new HashMap<>(); // Simulating database for user validation. Replace it according to actual use case 
                                                            
    public void validateUser(String username , String password) throws AuthFailureException{      
        if(!validUsers.containsKey(username)){        
            throw new AuthFailureException("Invalid Username");           // Custom exception, not a security issue as in real world you need to implement authentication against actual database or other methods 
                                                             }else if (!validUsers.get(username).equals(password)) {       
             throw new AuthFailureException ("Password is incorrect for the provided username.");      // Security sensitive operation related to Authentication failure           
         }      
    }         
}