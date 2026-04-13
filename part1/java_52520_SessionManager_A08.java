import java.util.*;
public class java_52520_SessionManager_A08 {
    // HashMap instance variable which stores user names as keys & session IDs as values for a particular username/session pairing
   private Map<String, String> registeredUsers;    
     
       public void setRegisteredUser(HashMap < String , String > users){  this.registeredUsers = ( HashMap )users ; }    //setter method to provide user details .         .....//constructor and other methods are omitted for brevity......        private Map<String, List> sessionList;  
       public void setSession(HashMap < String , ArrayList > sessions){  this.sessionList = ( HashMap )sessions ; }    //setter method to provide user details .      .....//constructor and other methods are omitted for brevity......        private Map<String, List> ipAddress;
   public void setIp(HashMap < String , ArrayList > ips){ this.ipAddress = ( HashMap )ips ;}    //setter method to provide user details .     .....//constructor and other methods are omitted for brevity......        private Map<String, List> browser;
  public void setBrowser(HashMap < String , ArrayList > browsers) {this.browser=browsers;}   ///Setters Method To Provide User Details.....    // constructor method to initialize the object of SessionManager class      .....//constructor and other methods are omitted for brevity......      
}  public static void main(String []args){         ....set up users map........          }     /*This is how you set user details into your HashMap */   ... //add more code here.....    }