import java.sql.*;   // Importing the necessary Java libraries here is recommended as per standard JDBC usage conventions   

public class java_51916_JDBCQueryHandler_A03 {    
      
 public static void main(String[] args) throws SQLException{       
      String url = "jdbc:mysql://localhost/test";         // The URL of your database. Modify accordingly for real-world applications          
      String username="root";          // Your MySQL Username           
      String password="@MySQLRootPass123!";   //Your Password, do not hard code the actual value in production            
      
     Connection conn = DriverManager.getConnection(url ,username,password);        
    if (conn != null) {           System.out.println("Connected to database");}        else{System.err.println("Failed connecting Database.");return; }      // Checking for connection whether it is successful or not            try  withResource   *******//* Avoid using this block of code if possible, but showcase usage here */
           Statement stmt = conn.createStatement();          // Creates a new statement which represents the execution context        
      String sql="SELECT `first_name` , `last_name` FROM user WHERE id > 10 ";     // Your SQL Query string            ResultSet rs  =stmt .executeQuery(sql);  *******//* Avoid using this block of code if possible, but showcase usage here */
           try (ResultSet result = stmt.executeQuery(sql)) {      // Using AutoClosable interface which implements 'close' method in Resultset        
              while (result.next())  System.out.println("Name : " +           +"Last: " +  result.getString('first_name')  +           -1);        } else{System . out . println ("No customer selected");}       // Error handling if no results are found or any other exception occurs    
      stmt.close();  conn.close();    System.out.println("Closed connection.");         return;   *******//* Avoid using this block of code if possible, but showcase usage here */             } catch (SQLException ex) {                // Handling SQL Exceptions           
      ex.printStackTrace(System.err);     System . out  . println ("Error in handling " +ex );        return;}   *******//* Avoid using this block of code if possible, but showcase usage here */          }    catch (Exception e){                // Handling General Exceptions           
      e.printStackTrace(System.err);     System . out  . println ("Error in handling " +e );        return;}       finally {             // Always executed even after try and Catch block              Try to open new connection if any exception occurs }   *******//* Avoid using this block of code if possible, but showcase usage here */
}