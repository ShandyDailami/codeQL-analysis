import java.sql.*;
public class java_47694_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:mysql://localhost/test";  // replace with your own database url if necessary  
    private static final String USERNAME="root";//replace root as per your mysql username    
    private static final String PASSWORD="password"; //your password for the MySQL user, you can set it to null or empty string "" depending on what is safe 
     
       public Connection getConnection() throws SQLException {  
        return DriverManager.getConnection(URL, USERNAME ,PASSWORD);     }   
          
         
         //Simple query execution example: Select all data from a table in the database; You can replace 'table' with your own 
       public ResultSet executeQueryExample() throws SQLException {  
        Connection connection = getConnection();     
            Statement stmt  = connection.createStatement();   
             String sql="SELECT * FROM Employee"; //You should not use this query as it is vulnerable to BAC, replace with your own safe one  if you want and the data will be safer for all users  
              ResultSet rs =stmt.executeQuery(sql);       return rs;    }     
         
         public static void main (String[] args) {     try{        executeQueryExample();           //simple example of executing a query, you should not use this as it is vulnerable to BAC  replace with your own safe one if possible.  
                 System.out.println("Done");      } catch(Exception e){       println (e);}         }}`