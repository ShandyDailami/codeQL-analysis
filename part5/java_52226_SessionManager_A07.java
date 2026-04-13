import java.util.*;   // Import needed collections and map interfaces    
interface Session {    // Define our 'session manager'. It should have methods for creating sessions (create) & destroying them ('close')  etc...
       void create(String id);      // Create a new session with the given ID, if it doesn't exist already. If does then do nothing or throw exception?  
        Session getSessionById(String keyId);     // Returns an existing/existing instance of 'session', based on provided identifier ('key')  OR throws NoSuchElementException;     
       void close ( String sessionID );    /* This will actually remove the "active" Sessions - if you try to open a nonexistent Session, it would not be able find */   // Closes an existing 'session', removing all references and data associated with that specific one. 
}       
public class java_52226_SessionManager_A07 implements Session {    /* Define our session manager implementation as per interface specification here*/    
       private Map<String , String> sessMap;         /// Create a map to hold the sessions...   // Here we can use Java's 'Hashmap'. This is where all of out active user connections will be kept. 
        public java_52226_SessionManager_A07() {    /* Constructor - here, initialize our session manager */    
               sessMap = new HashMap<>();         }       void create(String id) {}      // Implementation missing for the 'create' method...   Session getById ( String keyId )  throws NoSuchElementException{ return null;    /* Return a existing/existing instance of session, based on provided identifier ('key') */
        public java_52226_SessionManager_A07() {       void close(String id) {}          // Implementation missing for the 'close' method...   }     Session getById ( String keyId ) throws NoSuchElementException{  return null;    /* Return a existing/existing instance of session, based on provided identifier ('key') */