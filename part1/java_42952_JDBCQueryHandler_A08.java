import java.sql.*;
public class java_42952_JDBCQueryHandler_A08 {
    public static void main(String[] args) {  
        String url = "jdbc:mysql://localhost/dbname"; // Replace with your DB details, e.g., jdbc:mysql://localhost/test_database?useSSL=false&rewriteBatchedStatements=true 
        Connection con = null;    
         try {  
            Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL Connector jar file, replace with your specific driver for the DBMS you're using   
             System.out.println ("Connecting to database..."); 
               con = DriverManager.getConnection(url,"username","password" );  
            Statement stmt=con.createStatement();    
              String sql;      // SQL Query        
                if (true) {          // Assume that the operation is successful for now   
                   System.out.println("Inserting a row into table..."); 
                    try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test_database?useSSL=false","username", "password"); Statement stmt = con.createStatement()) {   // Using the same connection for multiple operations, better practice than using separate connections per operation   
                        sql  ="INSERT INTO tableName (column1 , column2) VALUES ('ValueOne', 'valueTwo')";  }      catch(SQLException e){e.printStackTrace();}     System.out.println("Inserted into the database");   // Insert query       stmt .executeUpdate(sql);
                    }} else {          // Assume that an integrity failure occurs here   
                   sql = "DELETE FROM tableName WHERE condition";  }      catch (SQLException e) {e.printStackTrace();}     System.out.println("Integrity Failure, data not deleted");   stmt .executeUpdate(sql);       // Delete query          con.close();
                }}    else{System. out . println ("Failed to connect database..." );  }           return;                 catch (SQLException ex) {ex.printStackTrace() ;}     System.out.println("Closing the connection");   if(con != null){try { con.close(); }catch ( SQLException e ){e . print stack trace () };}}