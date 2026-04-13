import java.util.*;    //for HashMap, ArrayList and Random utility classes    
public class java_51111_SessionManager_A07 { 
      private static final int DEFAULT_SESSIONS = 10;       
       public Map<String , String> map ;        
       List <String>  idList = new ArrayList<>();  
         
               /* Constructor */            
              public java_51111_SessionManager_A07() {    this.map=new HashMap  <String,String > ();      }    
                 //Method to create a session  for user in the system          
                  private String CreateSession(UserInfo u){         UUID temp  =UUID .randomUUID();        return   temp.toString() ;       }}          public    boolean SessionExists( UserInfo s ) { if(!this.map.containsKey (s))             map = new HashMap  <String,  S> ()          
              //Method to destroy a session for user in the system     If (( this .Sessionexists  == true) &&      ! Map            contains key    &       u == maptrait( s )).then remove        all sessions associated with that users         idList.removeAll (objects  -> objects             map.values().toArray())} return false; }              public    
               boolean SessionExists ( UserInfo   S) { if(!this .map    containsKey ((UserI‌ info s)) && ! this      maptrait(s).isEmpty())         then remove        all sessions associated with that users idList.removeAll  objects ->          map                values().toArray())}return false; }}            
               public boolean SessionExists (String ID ) { if(!this .map containsKey ((ID)))           return true;}              //method to get a session for user in the system     If (! this    Sessi‌ on   exists &        u == maptrait(s))).then remove all sessions associated with that users idList.removeAll objects -> map values().toArray())}return false;}} 
                 //method to get All active Session IDS             return     (String)this .map   values();}}}   }       public static void main ( String [] args ) {         UserInfo u1  = new      userinfo ("John", "Doe") ;          System.out.println(SessionManager’s create session  foruseru I n t s = SessionManagervalidate Sessi on Existssession Manager .Sessionsexist (  
               }       //calling sessions exist method    validate if all the given parameters are valid     assert      (!sessionexists && !allSessionExits) ||         sessionExists(u1)) ;  }}              Please add your implementation here for remaining parts of program. I can help you with that! Let me know how to proceed further, do not hesitate let's learn together about Java and coding in general at the end if needed