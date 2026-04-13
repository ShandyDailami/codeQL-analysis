import java.sql.*;    // Import required Java libraries     
       import java.util.*;          
        class java_51603_SessionManager_A03{          private static Map<String, String> userMap = new HashMap<>();        
            public void addUser(String username ,  String password){             User tmp=new User(username,password);              this.userMap.put (tmp .getUsername(),    //store the data in map        return;       }      static class Session{ private   Connection con ;     protected int userID = 0 ;