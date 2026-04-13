import java.util.*;   // Importing all utilities needed including LinkedHashMap, HashSet etc.,   
class java_53736_SessionManager_A03 {    
// Create a new instance of the map data structure (dictionary) called sessionStore with String as key and Integer object value in Java Map     
private static Map<String ,Integer> sessionStore =new LinkedHashMap<>();  // This is where our sessions are stored. It's not recommended to use this for real-world applications, but here we will do it like a simple example    private static int sessionIdCounter = 0;   public SessionManager(){};
public synchronized String createSession(String userName){     System.out.println("Creating new sessions: "+userName);       // Generate unique ids for each users' login and store them in the map      this.sessionStore.put((++this.sessionIdCounter) + "",new Integer ());
return ""  +  sessionIdCounter;}   public void deleteSession(String user){    System.out.println("Deleting sessions: "+user);       // Remove users from our store, it's a one-to-one operation      this .sessionStore.remove((Object) userName)}
}    `  }