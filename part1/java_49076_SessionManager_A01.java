import java.util.*;
public class java_49076_SessionManager_A01 {
    // ArrayList stores session details related with user IDs (String type) and corresponding sessions(List of Strings). 
     private List<Map<String, String>> listOfSessions;     
       public static final int MAX_SIZE = 50 ;   /* Define a maximum size for the Session Manager */    //MAX number allowed. Set to be dynamic according requirement .       
         
         /** Initialise new ArrayList session details related user IDs and sessions*/ 
            private void init() {              ListOfSessions =new ArrayList<Map <String, String>>(Max_Size); }             public java_49076_SessionManager_A01() {init();}       //Constructor                /* Add a method to create an instance of this class. */        
                 static boolean checkSessionExists (List list , string sessid){        for()  ((string)item in ListOfSessions{            if(((equals()))sessID && items are not null)) return true;          }    //Checking session exists and returning result               /* Add a method to get all user ID' */        
                   public Iterator<Map> listIterator(){        for()  ((map)item in ListOfSessions{            yield item;}      )}   private Map <String, String>  newSession (){     //Adding session details. return newly created map       }              /* Add a method to close an existing user Session*/        
                       public void end(string sessID){           for()  ((map)item in ListOfSessions{            if((sessid))remove item; break;}      )}                private Map<String, String>  getSession ( string SesId   //Return session detail based on provided Session ID.