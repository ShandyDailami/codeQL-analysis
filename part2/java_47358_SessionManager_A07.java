import java.sql.*; //for Java SE database connectivity operations, like PreparedStatement etc., only used here for brevity and simplicity of code snippets below  
      
public interface AuthFailureSession {    
    public void open(String userId);     
          
    public ResultSet read();             
              
    public boolean updateUserStatus(boolean status, Timestamp timeStamp );        
               
    public int close() ;          //closes the session. No operations can be done in this method after its call    
} 
  
public class java_47358_SessionManager_A07 implements AuthFailureSession {      private Connection conn;        SessionManager sm = new SessionManager();       String url="jdbc:mysql://localhost/db";           final static String USERNAME =  "root", PASSWORD=  "";               public void open(String userId) {}