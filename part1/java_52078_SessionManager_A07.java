import java.util.*;
public class java_52078_SessionManager_A07 {
    private static Map<String , String> userDB; //simulating a database to store users and their passwords as map of username -password
    
      public void init() {//initialize the session manager, simulates opening connection with DB 
        userDB = new HashMap<>();        
          addUser("admin", "1234"); //adding sample admin for testing purposes      
    }  
  
public String validateUser(String username , String password) {//method to authenticate the users, simulates login operation with DB 
        if (userDB.containsKey(username)) {                
            if (!Objects.equals((char[] ) userDB.get(username).toCharArray(),password.toCharArray())){ // comparing plain text version of passwords  
                return "Invalid Credentials";    }            
          else  {return username;}         }}else     {'Return 'User not found' message if the provided details are incorrect'}           {"Username doesnt exist"} ;        throw new RuntimeException("Cannot find user");}      //exception handling for unhandled exception   public void end() {}//simulates closing connection with DB   
       }  SessionManager sm =new SessionManager();     try {sm.init ();String username="admin"; String password=  "1234567890qwertyuiopQWERTYUIOP",output; output  =   sm .validateUser(username,password ); System.out.println("The user is :  \n");
    if (Objects.equals((char[] )sm.getuserDB(). get ( username ), password)) {System. out . println ("Welcome ");} else{System..print ln("Invalid Credentials ") ;}}catch(Exception e)   {}finally     sm.end(); } 
      }}`;    //closes the code block and prints output as per instructions given above, please replace "//" with your own comments for better readability of codes! Happy coding in Java language!! :) A big thank you to Deepseek's AI model who is helping us out. If any more help or information needed don't hesitate..