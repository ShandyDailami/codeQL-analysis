public class java_42670_SessionManager_A08 {
    private static int sessionCount = 1; // Global count of created sessions, not recommended for production use due to thread safety issues and performance concerns since it's a shared resource in multi-threaded application. A better way would be using ThreadLocal or similar mechanism depending on your requirement. 
    
    public void startSession() {  
        System.out.println("Starting session " + (sessionCount++)); // Print the sequence number of each new created Session to check if they are sequential and not concurrently accessed by multiple threads simultaneously due thread safety issues in multi-threaded application context 
    }    
}