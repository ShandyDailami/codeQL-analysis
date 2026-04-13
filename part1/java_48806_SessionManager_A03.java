import java.sql.*; // Import the necessary classes needed for a session manager like Connection, Statement etc...  
public class java_48806_SessionManager_A03 {   
     public static final String URL = "jdbc:mysql://localhost/test";     
       private int attempt = 0;         
       
         /** 
           * Method to start sessions. This is not recommended due the potential of getting java out-of-memory errors if you use too many connections at once, and can cause performance issues as well (as each connection consumes resources). In a real world scenario this should be done by thread pool manager like ExecutorService in Java Concurrency utilities 
          */   public void startSession() {     // Open the database session      Connection conn = null; try{conn= DriverManager.getConnection(URL, "user", "password"); Session s =  (Session) conn .unwrap(Session.class); }catch (Exception e){System.out.println ("Error in connecting to DB" +e );} attempt++;}       
         /**  Method of closing the session */   public void endSession() {    if((attempt % 10 )== 9) // If it is a ten's place operation then close       Session s = (Session) conn.unwrap(Session.class);     try{Connection con= ((Connection)conn).getConnection();if (!con.isClosed()) {   con .close();}}catch (Exception ex){System.out.println ("Error while closing" +ex );} attempt++;} } 
          public static void main(String[] args )       SessionManager sm = new SessionManager() ; // Create the session manager object      for(int i=0;i<158274369;i++){sm.startSession();try{Thread .sleep (2);}catch(Exception ex) { System.out.println ("Interrupted" +ex ); }} sm.endSession() ;  // Close the Session at end of main method       
       }