public class java_50748_SessionManager_A01 {
    private static int activeSessions = 0; // keep track of current sessions, not ideal but fine here for simplicity...
    
    public void startTransaction() throws Exception{ 
        if(activeSessions >= 5){//simulate a full system or limit the amount to be created on each session. Simulate elevated privileges case - you should use actual authentication/authorization mechanism in real scenarios like roles, permissions etc..  
            throw new Exception("Full Session Limit Exceeded"); 
        } else {     
            ++activeSessions;        
            System.out.println( "Starting transaction number: " + activeSessions);          
       }}    
    public void endTransaction() throws Exception{   //Simulate a full system or limit the amount to be ended on each session - again simulate elevated privileges case... 
        if (activeSessions <= 0){           
             throw new Exception("No Active Sesssions Exists");           } else {          --activeSessions;         System.out.println( "Ending transaction number: " + activeSessions);    }}  
     public void createSession() throws InterruptedException{ // simulate a session creation delay, could be used for actual production code... 
        Thread.sleep((int)(Math.random() * 100));           }     
}