import java.sql.*;   // Import the necessary classes from SQL package   
// PreparedStatement, ResultSet and Driver are essential for JDBC functionality    
public class java_42485_JDBCQueryHandler_A08 {       // Defining a new Class named 'VanillaJdbcc'     
  private static final String DB_URL = "jdbc:mysql://localhost/test";   // This is your database URL (replace with the actual host and db name)    
  private static final String USERNAME="root", PASSWORD="password12345!";    // Replace this part for real user, password     
 public Connection connection = null;              // Declare a variable to store our database connections       
  
public void connect() {                       // Method named 'connect'      
  try{                           
     System.out.println("Connecting To Database...");           
    this.connection=DriverManager.getConnection(DB_URL, USERNAME ,PASSWORD );      // Get a connection to the database       
   }catch (SQLException e){                   // If there is any exception during our operation catch it here         
     System.out.println("Error Occured While Connecting To Database..."+e);        
    return;                                 
  }                                     if(this.connection != null) {                Console.log("\nYou Made It!");                  // If we are able to make a connection print this message                   else                   
     System.out.println("Failed in Connection");  
}                                                       public void disconnect() throws SQLException{         printf ("Closing database connections..." + "User Count :"+this.connection.getMetaData().getUsersCount());  // This method is used to close the connection                   }                          };                     Public static int main(String[] args){                 VanillaJdbcc obj = new VanillaJdbcQueryHandler();                  Console c=new console;obj .connect (); if (!OBJECT_EXISTS("employee")) { 
    // Try-Catch block for DB operations        try{                   FORCE INSERT INTO employee(id,name) VALUES ('1','John')                         }catch({                      obj.disconnect();throw                     });   return -2;      };};                    Console c=new console ;obj . connect (); if (!OBJECT_EXISTS("employee")) {    try{                   FORCE INSERT INTO employee(id,name) VALUES ('1','John')                         }catch({                      obj.disconnect();throw                     });   return -2;