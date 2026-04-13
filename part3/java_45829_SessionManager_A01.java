import java.util.*;  // Import necessary Java classes  
// A SessionManager can have multiple sessions, each with different data stored within it (HashMap)
public class java_45829_SessionManager_A01 {     
    private Map<String , String> map;     // Our simple key-value storage - equivalent to a database in this case.
 
    public java_45829_SessionManager_A01()       // Constructor for our session manager, initializing the hashmap where data will be stored (and accessed) by default is an empty HashMap{}  
        {this.map = new HashMap<String , String>();}    
         
      /* Session methods start */ 
    public void put(String key, String value){       // This method adds a pair of <key-value>  to our map (equivalent as in the database)   this is equivalent 'A01_BrokenAccessControl' part. Anything added through it should be secured appropriately or not at all if no security measures are applied
        /* Adding data into Hashmap */    // Here we add a pair of key-value to our map, where each unique id maps back  -to the corresponding value (which may simply mean that record is deleted)   this follows 'A01_BrokenAccessControl' part. Anything added through it should be secured appropriately or not at all if no security measures are applied
        // Add your implementation here to make sure any operation related with a key in map will follow the principle of AOOBS (Above Obvious, Break Above Secure)  ie: data-accessed must comply directly and only via methods inside this class or another. No external calls allowed except put method
        // Also add validation if null keys/values are provided according to 'A03_SideEffects' principle   by preventing these operations before adding into the map (or any other operation)  like checking for invalid data, etc.. on input and after processing should follow this. Again based upon AOOBS
        // Also in case of multiple concurrent accesses at same time it must be handled securely ie: synchronization methods used when inserting or getting keys/values may also come into play here like ReentrantLock, Semaphore etc which depends on use-case. This should follow A02_Deadlocks and 479A1(S) as well
    }   //end of put method     /* Session methods end */     
}                          // End the VanillaSession class definition         (