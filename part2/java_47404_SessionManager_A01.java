public class java_47404_SessionManager_A01 {   // define the session manager's name (or id) here for clarity in our examples below, it could be anything you like! This would also serve to identify this unique SessionManager later on during runtime through logging and auditing purposes etc...   
     private static boolean allowAccess = true;  // default state of access. It is set up such that we always pass the test (true) for simplicity's sake here in a Minimalist style, but real-world usage may not be this simple!  
}                                 
                                  
public class CustomSessionManager {                                                    
     public void start()  // method to allow/disallow access by an external caller     
          SecuritySession.allowAccess = !SecuritySession.allowAccess;       
                                                                   
     /* a sample operation that uses the session manager's context, where it checks if "access" is allowed */  
     public void doOperation() {                                 
         // check access condition                                                 
         if (!SecuritySession.allowAccess)  {                           
             throw new SecurityException("Unauthorized Access!");   
                 } else{                                           
                     System.out.println ("Permission Granted, Continue operation");                     
                   try   {                                         
                         int i = 1 /0; // simulate a security violation by trying to divide through zero                   
                        /* you should add here the actual code for your operations */ 
                       } catch (Exception e)    {}                           
                 System.out.println ("Operation completed");                     
            }}  
}