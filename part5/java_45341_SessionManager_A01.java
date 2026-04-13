public class java_45341_SessionManager_A01 {
    private static int sessionCount = 0; // Keeps track of active sessions. Only necessary if you need a way for users to identify their connections back after they've logged out, this isn’t used here though as we are not tracking user login statuses at all now  
    
    public java_45341_SessionManager_A01() {  }     
      
        // Method that creates and manages session. This is a placeholder for your real code where you would actually create the JDBC Session, handle SQL Exceptions etc...
        
            private static final String URL = "jdbc:mysql://localhost/test";  
           private  static final String USERNAME="root";   
          private static final String PASSWORD=  "password1234567890?";       //Never hardcode passwords or use them in real-life applications, store hashed versions instead.     
         public void createSession() {   sessionCount++ ;     System . out  .println (“Created new Session ID :” +  sessionCount ); }   
        /* The methods below are a stub for your code that would handle closing of sessions etc... */          //Stubbed method to be filled in with real implementation.      public void closeSession() {   if(sessionCount > 0)  sessionCount--; System . out .println (“Closed Session ID :” +    sessionCount ); }
         /* The methods below are a stub for your code that would handle getting the current sessions etc... */     //Stubbed method to be filled in with real implementation.       public int getActiveSession() { return  this.sessionCount; }}