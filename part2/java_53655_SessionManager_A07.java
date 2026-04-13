public class java_53655_SessionManager_A07 { 
     // Instance Variable, we will use this variable as our session id later on     
     private static Integer sessionIdCounter = 0;      
         
     public void startSession() throws Exception{       
         ThreadLocal<Integer> mysession = new ThreadLocal<>();   
         if (mysession.get() != null) {                // check the thread local variable is not already set     
             throw new Exception("already started session");  }          else   {            msession.set(++SessionManager.sessionIdCounter);       }}                 
     public void stopSession(){              ThreadLocal<Integer> mysession =new    ThreadLocal<>(); if (mysession .get() == null)           // check the thread local variable is not set, then throw exception      Exception("not started session yet");          } else { msession.remove( );}                 
     public Integer getSessionId(){              return  this  ==null?Thread.currentThread().getId():this    .hashCode();}}            });        }}                   // end of start and stop methods                 private java_53655_SessionManager_A07() {}           };