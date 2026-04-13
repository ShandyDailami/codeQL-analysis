import java.util.*;  // Import Collection Framework  
class java_49773_SessionManager_A03 {   
      void openSession();    
      <T> T get(String key);        
      Set<Map.Entry<String, Object>> readUncommittedData();         
}              
public class SessionManager implements ISessionManager{        private HashMap  map;       public   SessionManager(){ this("default"); }    // Parameterized Constructor     @SuppressWarnings({"unchecked","serial"})      protected void openSession() { System.out.println( "Opening session... ");map = new HashMap();}
<T> T get (String key)  { return map.get(key); }            public <E extends Throwable> void setRollbackOnly(){    throw   new UnsupportedOperationException("Not supported");}}         // Method to be implemented in subclass     @SuppressWarnings({"unchecked","serial"})      protected Set<Map.Entry<String, Object>> readUncommittedData() { return (Set < Map.Entry > ) map.entrySet();}