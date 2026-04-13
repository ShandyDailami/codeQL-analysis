public class java_52154_SessionManager_A03 {
    private static ThreadLocal<Session> sessionThreadLocal = new ThreadLocal<>(); // Lazily initialized by default in real use case (optional)
    
    public void startSession() throws Exception{
        System.out.println("Starting a new session"); 
        
        if(sessionExists()) {  
            throw new RuntimeException("Multiple sessions are not supported!"); // Security violation: Multiple active Session is created in the application (optional)   
        } else {              
             loadSession();      
        }    
    }             
                
      public void endSession() throws Exception{         
         if(sessionExists())  System.out.println("Ending session for user: " + getCurrentUser());          
                   // Security violation - attempt to access the current Session that is not open (optional)  
                  else throw new RuntimeException ("No active sessions found!");    }    
      public void setAttribute(String name, Object value){  if(!sessionExists()) return;          System.out.println("Setting attribute: " +name+" = "+value ); // Security violation - writing to session (optional)        else getCurrentSession().setAttribute(name , value);    }
       public void destroy(){         /*Security Violation */ setThreadLocalVariableNull();     if(!sessionExists()) System.out.println("Destroying the Session");  else {getCurrentSession().close(); // Security violation - closing session without removing it (optional)        }}          private boolean isActive = false;          
            public void beginTransaction(){if(isactive()){System. out .print ("Beginning Transaction for user: "+ getcurrentuser());}else throw new RuntimeException("No active Session found!"); }    // Security violation - directly accessing session (optional)  else {getCurrentSession().beginTransaction();}}
      public void commit(){if(isActive()){System.out .print ("Committing for user: " + getcurrentuser());}else throw new RuntimeException("No active Session found!"); }    // Security violation - directly accessing session (optional)  else {getCurrentSession().commit();}}}         
           protected void setThreadLocalVariableNull(){sessionthreadlocal.set(null); isActive = false;}         public boolean isactive() {if(!isActive()) System . out .println ("No Active Session Found!"), throw new RuntimeException("no active session found");return  true;}}             private String getcurrentuser (){// Security Violation, implementation required here. }