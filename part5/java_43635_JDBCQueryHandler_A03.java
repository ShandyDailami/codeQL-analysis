import java.sql.*;

public class java_43635_JDBCQueryHandler_A03 {   // Start of code snippet that starts with ''''java'
    private static final String url = "jdbc:mysql://localhost/test";     // Database URL, you should replace this to match your database setup 
    private static final String user ="root";                              // username for the MySQL server. You may need change it based on actual situation  
    private static final String password= "";                                // Password for both mysql and application users (you can use system property). Remember not store sensitive information like this in your code! 
    
// Below are JDBC drivers which you should replace with the one suitable to MySQL driver of java.mysql.* or com.mysql.jdbc.*; based on actual situation  
    static Connection con = null;                                  // variable for database connection, make sure it is not shared among threads and thread safe 
    
// Starts a DBConnection by opening up db connectivity     
public void startDBconnection() {                 
       try{                                             
           Class.forName("com.mysql.cj.jdbc.Driver");    // JDBC driver class name, make sure it is suitable for your case  
            con = DriverManager.getConnection(url , user, password); 
        }catch (Exception e){                         
          System.out.println ("Error in establishing the connection : " +e );            
       }                                                      // Ends catch block   
}                                                                    
// Executes a SQL query and fetches data  
public void executeQuery(String sql) {                      
      try{                                           
           Statement stmt = con.createStatement(); 
            ResultSet rs=stmt.executeQuery (sql);        // Here you should pass your parameterized or non-parameterized Query                   
          while (rs.next())                          // Fetching and processing data here, based on actual requirement  
         {                                          
             System.out.println(rs.getString("YourFieldName"));  // Use Field Name from ResultSet object as per your DB schema                
        }                                         
       con.close();                                    // Always close the connection after use     
     }catch (Exception e){                           // Catch block for Exception  
         System.out.println ("Error in fetching data : " +e );   
  }                                                      // Ends catch blocks                            
}                                                                               
// Main method to start point of execution                    
public static void main(String[] args) {                   
       VanillaJavaJdbcQueryHandler v = new VanillaJavaJdbcQueryHandler();   // Create an object for the class   
      v.startDBconnection();                          // Start DB connection  here, use threading if needed                 
     v.executeQuery("YourSQLStatement");            // Execute SQL Statement Here                
}                                                                                                                    
// Ends of code snippet that ends with ''''java   and comments start below