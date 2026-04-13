public class java_49052_CredentialValidator_A03 {
    private String[] validUsers = {"admin", "user1"};  // Hard-coded list of users with correct credentials for validation purposes only, should not be used in real scenarios.
    
    public boolean validate(String userName, String password) {  
        if (isValidUserAndPasswordCombinationPresentInList(userName, password)) {      
            System.out.println("Login Successful!");          // This is just for demonstration purposes and not recommended in real-world scenarios due to security concerns above   
             return true;          
         } else{  
              throw new SecurityException ("Invalid Credentials");  ///This should be done securely, by hashing or salting passwords before comparison    
          }     
       }       
     private boolean isValidUserAndPasswordCombinationPresentInList(String userName, String password) {         // This method checks if the username and their corresponding hash in 'validUsers' list match           return Arrays.asList(this.validUsers).contains(userName+password);  }  
}