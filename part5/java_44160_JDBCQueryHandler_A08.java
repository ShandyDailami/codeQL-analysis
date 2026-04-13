import java.sql.*;
public class java_44160_JDBCQueryHandler_A08 {
    public static final String URL = "jdbc:mysql://localhost/test"; // Your database url here, e.g., jdbc:mysql://localhost/mydatabase  
     private Connection conn; 
      Statement stmt;
       ResultSet rs;
         try{               
           System.out.println("Connecting to " + URL);   
            this.conn = DriverManager.getConnection(URL, "username", "password"); // Your username and password here  
             if (this.conn != null) { 
                 System.out.println("Successfully connected with database!");      } else{        
                throw new Exception ("Cannot connect to the Database.");    }} catch(Exception ex){        for(int i = 0;i <ex.getStackTrace().length ; ++i )     //catch exceptions and print them          System.out .println (Ex. getMessage());  break;}   }            
           public void performQuery() {       try{      stmt = this.conn.createStatement();         rs  =stmt.executeQuery("SELECT * FROM Employee");        while(rs.next())    //process each row here     System .out .println ( "ID:  " +   rs.getString('id')); } catch({ e ->e.printStackTrace()})}}
              public void closeConnection(){ try{ this.conn.close();}catch(Exception ex){ex. printstacktrace ()}}}// Close the connection if an exception occurs          };      // Create a new instance of JDBCQueryHandler and call perform query  JDBCQueryHandler handler =new   JDBCQueryhandler ();    
               handle .performquery();    handling..closeConnection() ;}}`}