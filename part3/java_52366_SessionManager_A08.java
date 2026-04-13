import java.sql.*;    // for JDBC and SQL libraries      
import java.util.Date;     // Import the date functions from Java util package       
        
public class java_52366_SessionManager_A08 {     
          private int userID;          
          private long lastActiveTimestampMillisecs = 0L ; 
            
          public void setUser(int id){            this.userID =id;}   
                
              // Method to update Last Active TimeStamp    
         static boolean saveSessionDetailsInDatabase (Connection conn, int userId) {  
                  try{        Date d= new Date();  lastActiveTimestampMillisecs =  d.getTime() ;       DatabaseUser db =new    DatabaseUser(userID);             // Creating object of User with given ID     DB operations will go here      }catch (Exception e){ return false;}}  
          public boolean isSessionExpired(){  long currentTimestampMillisecs= new Date().getTime();       if((currentTimestampMillisecs-lastActiveTimestampMillisecs) > A08_IntegrityFailure ){        // Setting Threshold to check session validity here      return true;}}return false;}
    }