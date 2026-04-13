public class java_52611_CredentialValidator_A07 {    
    private String[] allowedUsers = {"admin","user1"}; // list of authorized users, in real applications you would use authentication services to check credentials and get user info. 
   public boolean isValid(String username) throws Exception{     
        for (int i = 0; i < this.allowedUsers.length; ++i){   
            if (!this.checkPasswordMatching(username, allowedUsers[i])) { // Compare with real authentication service's password matching logic 
                return false;   }     setTimeOut();      throw new Exception("Incorrect username or password.");       }}          private void setTimeOut() throws InterruptedException{         Thread.sleep((long) (Math.random() *100));    // simulate network latency for example, in real application you would use an asynchronous method to perform async call instead  }