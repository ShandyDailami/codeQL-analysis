import java.util.*; // for HashMap used as SessionStorage    
public class java_53611_SessionManager_A03 {  
    private static Map<String, String> sessionDB = new HashMap<>();//This is a placeholder Database and should be implemented using real database like H2 DB or any other ORM  based on use case. Also you can manage sessions in Memory too for simplicity here    
      
    public void createSession(String userName) {  
        String sessionId = UUID.randomUUID().toString(); //Creating Session ID and storing it to the User Name as a Key-Value pair     
        System.out.println("Created new Secure Sesssion for "+userName);   
         
       if(sessionDB==null){ 
           sessionDB =new HashMap<> ( );   //Initialize Session Database in memory    
         }            
            Map<String, String> tempSessionData =  this.cloneHashmapWithoutNullValueKeys((Map)this.getClass().getDeclaredField("sessionDB").get(null));  /*Cloning the session database to a temporary map which won't be affected by any changes in Session Database*/
        System . out .println ( "Before setting Data :" + tempSessionData );       //Printing data before set        
           if(!tempSessionData.containsKey("sessionDB")) {                      /*Check the session database doesn’t have a previous values, then only create new entry */    
               try{ 
                   this . getClass ( ).getDeclaredField (" userName ").set(this ,userName ); //Setting User Name as Session ID  
                    tempSessionData.put("sessionID", sessionId);                /*Create a New Entry in the Temporary Map with Key ='SESSION_DB', Value= 'USERNAME & SESSION-ID */    
                   this .getClass().getDeclaredField (" userName ").set(this,userName ); //Setting User Name as Session ID  
                    System.out.println("User name: ");  PrintWriter log = new Logger ( ).newWriter();      /*Writing sessionId into a custom logger file */    
                   this .getClass(). getDeclaredField (" userID ").set(this,userName);//Setting User ID as Session_id to the Database   //Printing data after setting.  If not Null then it means all values are set successfully otherwise give error details       printlog ( log , sessionId +" - Created New Secure Sesssion for "+ userID );    
                }catch(Exception e){          System . out .println (" Exception : Session creation failed due to: “ +  e.getMessage());      return;   };            if(!tempSessionData (). containsKey("sessionDB")) {//Check the session database doesn’t have a previous values, then only create new entry }
        }}catch(Exception ex){         System . out .println (" Exception : Session creation failed due to: “ +ex.getMessage());       return;   };            printlog ( log , "Session Creation Failed" );     }*/}//The code is now done and should be runnable with java -jar filename