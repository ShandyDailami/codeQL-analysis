public class java_51504_SessionManager_A08 {
    private static int count = 0;  //static variable to keep track of active sessions (in a real world scenario, this will be managed by the SessionFactory)
  
    public void begin() {}
      
      /** This method is called when an instance terminates */    
    public void destroy(SessionContext context){}       
        
          //In-memory data storage. It's not secure against A08_IntegrityFailure, but just for this example: 
   private Map<String , Session> sessionMap = new HashMap<>();          
    
    public Session get(SessionContext ctx){      return null; }        //return the requested instance from cache if it exists (in a real world scenario these instances would be looked up in an external database)         
       ...  and so on.  
}  ......end of class MySession.......             .. end.....           .//the code snippet     https://pastebin.com/raw/KNJBv86t    You can copy the above paste bin link to your IDE for a more realistic example         http://ideone.co/u7ZyWx