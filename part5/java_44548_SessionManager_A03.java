import java.sql.*;   // Import necessary Java libraries   
public class java_44548_SessionManager_A03 {     // Declare main Class which will handle all operations related to database connection & operation on tables/entities via sessions (connection pool)..      
      static final String url = "jdbcURL";//database URL, change it according your requirement.  
  private Connection con;    // Create a variable for DB connections    
 public java_44548_SessionManager_A03() { }         // Constructor to establish the database connection...          
public void openConnection(){        // Method which opens Database and creates session object if not created already..            
      try{                     
          this.con = DriverManager.getConnection(url, "username",  "password");     // Here we are using JDBC's built-in methods to connect the database with credentials...           
         }catch (SQLException e){          
                     System.out.println("Error in Connection" +e);       return;      // Catch any exceptions and print if occurred, then terminate method          };  
}  public void closeConnection(){    /// Method to Close the Database connection..             try{ this.con .close(); }catch (SQLException e){ System.out.println("Error in Closing Connection" +e); }}         // Here we are using JDBC's built-in methods for closing connections         
   public void execute(String query, String... params) {  /// Method to Execute the SQL Query and prevent Injection..       try{    PreparedStatement pstmt=con.prepareStatement (query);      if (!paramsIsNullOrEmpty())        // This checks whether there is any parameter or not          for (int i = 0;i < paramArray .length ;++ 2){             /* Here we are using JDBC's built-in methods to prepare and bind parameters...            pstmt.setInt(1); }           }}catch {e,print stack trace}}       
private boolean paramsIsNullOrEmpty(){} // Method which checks if the parameter array is empty or not         return (paramArray .length ==0)}    try{return false;}}}  catch({System..PrintStackTrace(){ System.out...} }); }// End of method, same comment block as above for more readability}}