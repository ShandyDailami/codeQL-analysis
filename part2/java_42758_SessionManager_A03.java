public final class java_42758_SessionManager_A03 {    
    private static int counter = 1;          // Global variable to count requests/sessions       
      
      public interface Operation{             // Define an operation for injection             
         void execute(HttpServletRequest request, HttpSession session);              
      }           
          
   public final class SessionManager {    
    private static ThreadLocal<Operation> operations = new ThreadLocal<>();         
               
       @Override                         
        protected Object clone() throws CloneNotSupportedException{             // prevent cloning of instance             
         throw new InternalError("Clonning not allowed for this class");               }          
      public static void set(Operation operation){                               // Setting the Operation to ThreadLocal           
          operations.set(operation);                                            
       }   
     @SuppressWarnings("unchecked")  private static <T> T get(){                   // Getting a previously stored SessionManager instance            
         return (T)operations.get();                                           
      }  
        public final class SecurityOperation implements Operation {              // Define the specific operation for security sensitive operations           
          @Override                                                              // Implement methods based on requirements of your application          
     void execute(HttpServletRequest request, HttpSession session){                  throw new UnsupportedOperationException();}               };  }                    
    public static class Main{       private final A03_Injection.SecurityManager manager = null;          @org.junit.Test         // Junit test for Session Manager      void a(){           try {            manager.set(new SecurityOperation());        }} catch (Exception e) {} }); }