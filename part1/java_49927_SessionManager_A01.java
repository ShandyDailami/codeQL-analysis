public class java_49927_SessionManager_A01 {
    private String[] activeSessions; // Store the IDs of currently connected users' session ids here (static array)
    
   public void openSession(String userId){        
        for(int i=0 ;i<activeSessions.length;i++ ){  /*Check if this sessions is already opened*/         
            //If found, then return with an error message            
           }      
               activeSessions[userId] = sessionIDGenerator();/*Assign a new ID to the userSession and assign it open state */     
   }   
     public void closeSession(String  Sessionid){         /*Close any opened sessions*/         
            for (int i=0;i<activeSessions.length ; ++ ){       //Iterate over all session ids        if this is not the user's one then continue to next      }    activeSessions[SessionID] = null;}  */     else {return "No such Session exists";}            
   public String getUserName(String sessId){         /*Get any open sessions*/       //If session found, return username of the user. Else throw exception        try{          for (int i=0;i<activeSessions .length ; ++ ) {     if this is not equal to SessionID then continue      } 
   public boolean checkPermission(String sessId , String permission){       /*Check Permissions*/           //If user has the given permissions, return true. Else false        try{          for (int i=0;i<activeSessions .length ; ++ ) {     if this is not equal to SessionID then continue      } 
}