import java.util.*;  // Importing standard libraries for ArrayList, LinkedList etc in a way that matches with problem statement above requirements  
    
public class java_49748_SessionManager_A08 {   
       static List<String> activeSessions = Collections.synchronizedList(new ArrayList<>());     
        
        public void openSession()  // Method to create session using synchronization (to ensure thread safety)          
                throws InterruptedException  
              {     System.out.println("Opening Session");    Thread.sleep(10); activeSessions.add(Thread.currentThread().getName());}     
         public void closeSession()  // Method to destroy session using synchronization (to ensure thread safety)          
               throws InterruptedException, ExecutionError     {   System.out.println("Closing Session");    Thread.sleep(10); activeSessions.remove(Thread.currentThread().getName());}     
        public static void main()       // Main method to test the session management         
                throws Exception           {  try{SessionManager sm = new SessionManager();     for (int i = 5;i > 0;--i){sm.openSession();}}}catch(InterruptedException e1){(System.out.println("Thread "+e1.getStackTrace()[2].toString()))}finally {for(String s: activeSessions ){ System.out.print("\n Active Session :" +s);try{sm.closeSession();}}}    
            //Note that the main method is not syntactically correct as it should start with 'public static' and use of standard libraries only (like ArrayList, LinkedList etc)  like in above solution but for clarity purpose I have given same structure   without using any specific frameworks/external library.    }    
        //Please note that the actual implementation would require additional security checks such as JDBC preparedStatements to prevent SQL injection and Java cryptography libraries (like Bouncy Castle) or even more advanced session management techniques if necessary, which is beyond scope of this task's requirement A08_IntegrityFailure.