import java.sql.*;  // Import required Java libraries here... you need to have jdbc driver for your database, e.g., MySQL Connector J or PostgreSQL Driver etc..
  
public class java_46233_JDBCQueryHandler_A01 {    
    public static void main(String[] args) throws SQLException{       
       String url = "jdbc:mysql://localhost/testdb";      // Use your database details here... e.g., jdbc:mysql://username@password@hostname/databasename  for MySQL DB  
       String username="your_user", password="passwd1234567890!";     // Replace with correct credentials (security sensitive)       
           
       try {               
           Connection con = DriverManager.getConnection(url,username ,password);        
      ...    }  catch {}   finally{con != null && con.close();}            
                 .....             
               } // end of main method         
     protected static ResultSet executeQueryHandler (String query) throws SQLException {      
           Statement stmt = con.createStatement(java.sql.ResultSet.TYPE_FORWARD_ONLY, java.sql.ResultSet.CONCUR_READ_ONLY);        //Create statement object        
            return  stmt .executeQuery (query) ;   }       ...      ......     catch {}};    finally{stmt != null && stmt.close();}          .....           };