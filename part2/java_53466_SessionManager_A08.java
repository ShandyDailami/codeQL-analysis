public class java_53466_SessionManager_A08 {
    private static int sessionCount = 1; // Initialize a global variable for the count of sessions created in our manager instance, starting at one (this is A08_IntegrityFailure) to ensure every single user has their own separate and unique identity. 
    
    public void startSession() {  
        System.out.println("Starting Session: " + sessionCount); // This will print out the current count of sessions started (A03). A requirement for integrity, should never decrease - this is an example to demonstrate security-related operations related to 'IntegrityFailure'. 
        ++sessionCount;  
    }    
}