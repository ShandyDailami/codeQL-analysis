public class java_52770_SessionManager_A08 {
    private static int nextId = 1; // This field will hold the id of a session currently created by our manager instance, and incremented each time we open up an ID space for use within these methods: ++nextID (). You should have one in your program to keep track when you're opening new sessions.
    
    private static ArrayList<Session> allSessions = null; // List of currently created session objects are held here by the SessionManager object and accessible via this instance variable. This list is maintained outside of methods so as not to disturb other method calls in a multithreaded environment (and thus, should be done using synchronization facilities provided with Java).
    
    public static int createSession() { // Creates an ID for the session - each call returns different integers and when SessionManager's close will clean up. 256 bit integer number is used here because it can handle a maximum of about four terabytes (340 bytes) in memory, which should be more than enough to support many sessions that might exist at once during the lifetime of an application program running on multiple threads or processes:
        int newId = nextId++; // This line will increment "nextID" each time we create a session. 1 bit integer number is used here because it can hold only two values (0 and 256) as per Java's byte limit for the Integer data type, which should be sufficient in our case:
        Session newSession = null; // Create instance of object to store details about each open session. Note that this class does not need a real constructor since all fields are set up by an external source (such create sessions): 1 bit integer number is used here because it can hold only two values (0 and the maximum int value).
        return newId; // Return ID of newly created Session:
    }    
}