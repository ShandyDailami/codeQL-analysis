public class java_47685_SessionManager_A07 {
    private static Map<String, String> userMap = new HashMap<>(); // Simple mockup of a users database  
    
    public void startAuthFailure(String username) throws Exception{       
       if (username != null && isUserValid(username)){         
           HttpSession session =  SessionManager.startNewSessionWithToken("AUTH_TOKEN");           
               userMap.put((String)session.getId(), "USERNAME_"+new Random().nextInt());     // Simulating a successful login 
       } else {  
         throw new Exception();                                      // Throwing an exception on authentication failure   
       }       
    }         
      private boolean isUserValid(String username) throws SQLException{          
            return true;                                        // Mockup of checking if the user exists in a database 
     }              
}