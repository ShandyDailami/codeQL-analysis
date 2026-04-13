import java.sql.*;   // Import the necessary Java library classes 

public class java_43794_JDBCQueryHandler_A01 {
    public static void main(String[] args) throws SQLException{    
        String url = "jdbcUrl";                    /* Define your database URL here */              
        Connection conn  = DriverManager.getConnection (url, userName , password );   // Setup the connection with DB 
                                                                                         
       Statement stmt   = null;                     // Declare statement object for handling SQL queries        
      ResultSet rs     =null ;                       /*Declaring result set */            
        try {   
            conn.setAutoCommit(false);                 // Disable Auto Commit to handle multiple operations at once 
                                                                                               
                                                            stmt   =conn .createStatement();   / Create a statement object for the database connection    
         rs =stmt.executeQuery("SELECT * FROM YOUR_TABLE"); /* Execute your SQL query here */            
          while (rs.next()) {                          // Fetch Data from Result Set one by one   
            System.out.println(rs.getString('YOURFIELD'));  // Print out the data you want to access   like 'name' for example above     }                                                                                                                    catch(){}finally{conn?.close();stmt ??: rs .close(): null;}}}))))         /* close connections */