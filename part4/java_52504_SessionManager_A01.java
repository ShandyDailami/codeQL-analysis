import java.util.*;
public class java_52504_SessionManager_A01 {  
    // Define the user list for authentication purposes; this is a dummy variable, you should use your own database here!     
     private List<User> users = Arrays.asList(new User("user1", "password"), new User ("admin","top_secret")); 
      
   public String login (String username, String password) { //authenticate the user and return a session token or null if authentication fails   
     for(User u : users){     
         if((u.getUsername().equals(username)) && (hashPassword(password).equals(u.getPassword())){       
             UUID uniqueID=UUID.randomUUID();          //create and store a session token       System.out.println("Session ID:" +uniqueID);     return   uuid;    }      Collections.shuffle(sessions.list());  } catch (Exception e) {e.printStackTrace()};return null;}
         public String hashPassword(String passwordToHash){ //hash the inputted users'password to check against in database and returns a hashed version of it       try{      MessageDigest md = MessageDigest.getInstance("MD5"); byte[] hashbytes=md.digest((userpass + salt).getBytes());return new BigInteger(1, hashbytes).toString();} catch (NoSuchAlgorithmException e){e.printStackTrace() }; return null; } 
   //add session token to the list of active sessions and logout user in a function called "logOutUser"      void loggedInUsers =new LinkedList<>( );     public static String Loggedinuser=null ;    if (sessionslist.containsKey((uniqueID))){        Session sess  = new 
Session();       Sessionsusersidemap .put (( unique ID),session);          Systemoutprintln("User is logged in.");         return   session; }else{return null;}     public static void logOutuser(){      if(Sesstions users id map.containsKey((uniqueID))){             sessionslist..remove (uniqueid );           Loggedin user=null ; 
Systemoutprintln ("User is logged out");} else { Systemerrorgiven the session"does not exist")}}    }   //The Session Manager class ends here, it does nothing but to illustrate how we can implement a secure login and log-off system. It's very simple in this example however when dealing with authentication you should use more robust methods (like OAuth/JWT) especially for production applications where data breaches are not uncommon!