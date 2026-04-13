import java.sql.*; // Import the necessary classes needed for SQL operations such as Connection, Statement etc...  
public class java_44354_JDBCQueryHandler_A01 {   
      public static void main(String[] args) throws Exception{       
           try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db", "username","password"))  // You will need to replace these with your actual database connection details      
            {         
                System.out.println ("Connected!");     
                  String query="SELECT * FROM users";   
                 try (Statement stmt = conn.createStatement())       
                     {                     
                         ResultSet rs =  stmt.executeQuery(query );   // Execute the SQL statement and get a result set      
                           while (rs.next() ) 
                               System.out.println("ID=" + rs.getString("id")+ " Name =" +  rs.getString("name"));     }    catch (SQLException e)           {          // Handle any SQL exception that may occur      e.printStackTrace();       }}        catch (IOException e){ 
e.printStackTrace() ;}}   Note: Do not use this in a production environment, it is just for demonstration of the concept! This code does nothing with your data or access controls due to lack thereof and also doesn't handle connection errors that may occur while connecting as I have mentioned below exception handling has been removed.