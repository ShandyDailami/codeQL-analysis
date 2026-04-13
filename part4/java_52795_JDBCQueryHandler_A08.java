import java.sql.*;   // Import necessary Java libraries   
public class java_52795_JDBCQueryHandler_A08 {     // Declaring a new Class named 'JDBCQueryHandler'     
      
 public Connection connectToDatabase(String dbURL, String username , char[] password) throws SQLException  {          
        return DriverManager.getConnection(dbURL,username,password);    }  
         
public void executeUpdateOperation (Connection conn )throws SQLException{     // Declaring a new function to handle Update operations     
         Statement stmt = null;                          
                try {stmt  =conn .createStatement();}  catch (SQLException e)      
                 {}                                             
                    String sql="UPDATE Employees SET salary = 205 where EMP_ID > 18";     // Updating the SQL statement here     
                   stmt.executeUpdate(sql);                          }  
                finally {stmt.close();}    }                       public static void main (String args[])throws SQLException{        new JDBCQueryHandler().connectToDatabase("jdbc:mysql://localhost/mydatabase", "root","password".toCharArray());  executeUpdateOperation(conn);}}