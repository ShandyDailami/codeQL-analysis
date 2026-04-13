import javax.management.*;
// We will use MBean Server, which allows us perform server side monitoring with JMX tool like any other Java program... But for this example we do not need it  
public class java_45302_SessionManager_A03 { // This is a simple user session manager without real security measures and in memory storage  (for simplicity).. you should implement the actual secure way of handling sessions as well. Here only used standard library concepts & methods are shown, no external libraries or frameworks were involved at all to make it legacy style
    private static int counter = 0; // This will store how many session objects have been created...for testing purposes  (not a real-world secure way)  
    
// Create Session Method.....to add into the list of active sessions. No security measures are involved here, so only one user can be logged in at once....(Testing Purpose). In reality you would need to use some kind or mechanism that implements authentication and authorization  (like JWT / Spring Security)
    public static Session createSession() {   //This is a simple way of creating sessions...For real world application, session management should be implemented properly with security measures. But for testing purposes it's enough to show how you can do this here..(Testing Purpose).  In reality there are more advanced ways like using Java EE Managed Beans or Spring Security JWT
        counter++;   //Increase our session count...for example purpose only. You should use a secure method instead of just incrementing the variable in each Session, to avoid SQL injection attacks etc..  (Testing Purpose). In real world application you have user-specific sessions and not all users are connected at once
        System.out.println("Created session #" + counter); //Simple output for testing...In a production environment we would use more complex logging or monitoring techniques  
    }                   
}