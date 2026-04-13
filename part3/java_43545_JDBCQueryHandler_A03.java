import java.sql.*;   // Import necessary classes for database connectivity, such as DriverManager & ResultSet etc
    
public class java_43545_JDBCQueryHandler_A03 {    /* Start of the code */
        
        public static Connection establishConnection(String dbURL) throws SQLException{       /* Function to connect with Database using Java DB API.*/ 
            return DriverManager.getConnection(dbURL, "username", "password"); // Replace username and password as per your database credentials  
     }   
     
        public static void main (String[] args) throws SQLException {         /* Main function to test our code */      
             Connection con = establishConnection("jdbc:mysql://localhost/testdb?useSSL=false");  // Replace "username", password & dbURL as per your database  
     }   
     
        public static void closeConnections(ResultSet rs, Statement stmt , Connection conn) throws SQLException { /* Function to cleanup our connections */      
             if (rs != null ) 
                  rs.close();         // Close the Result Set  
              if (stmt != null )   
                 stmt.close();        //Close Prepared Statement    
               if(conn!=  null)     
                    conn.close();       // Closing database connection            
          }  /* End of close connections */           
          
         public static void performQuery (String query, Connection con ) throws SQLException {    /** Function to execute our queries*/  
              Statement stmt =con .createStatement(java.sql.ResultSet.TYPE_FORWARD_ONLY);  // Create a new statement and set it as resultset type forward only    
             ResultSet rs=stmt.executeQuery("SELECT * FROM EMPLOYEE WHERE AGE>"+query );    /* Execute the SQL query to get all records */  
                  while (rs !=  null && rs.next()) {         // If there is a record left    
                      System .out.println( "ID :  " +rs.getString("Age"));       /** Print out Age from employee table*/    }); } /* End of performQuery function */     
}