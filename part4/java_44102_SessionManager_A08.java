public class java_44102_SessionManager_A08 {
    private static int numSessions = 0; // To count sessions created to ensure correct integrity failures in A08_IntegrityFailure test scenario    
     
    public void startSession() throws Exception{  
        if(numSessions > 1){// If more than one session is already running, fail the Integrity Failure Test. 
            throw new Exception("Too many sessions are currently active");      
        }         
        ++ numSessions; // Increment number of current Session in this Thread     
    }    
   public void endSession() throws InterruptedException {              --numSessions;}// Decrease the count for closing session.  If we get here, it means that no other threads are waiting or running (no integrity failures).        if( numSessions > 0) return; // Wait till all sessions have ended   
         Thread t =Thread.currentThread();     while((numSessions>1 || !t.isInterrupted()) &&  (!t.getStackTrace()[3].toString().contains("SessionManager")));//Waiting for remaining threads to end or if the session manager is interrupted by some other thread
         numSessions=0; // Reset number of active sessions    }     public static void main(String[] args) { SessionManager sm = new SessionManager();        try{sm.startSession();}catch (Exception e){System.out.println("Caught exception: " +e ); return;}        
try{Thread t=new Thread(() -> {  for (;;) {} });   // creating a thread in an infinite loop      sm.endSession();}} catch(InterruptedException ex)     {sm.numSessions = 0; System.out.println("End of sessions");}        finally{}return;}