import java.sql.*;  // Import necessary Java packages for JDBC (Java Database Connectivity) to execute queries and handle results efficiently  
    
public class java_44311_JDBCQueryHandler_A07 {    // Create a public static void main method in the end of this code block, so we can run it via command line arguments. In reality you'd only use these methods inside other classes or modules later on! 
      
      private Connection connection;  
    
        VanillaJdbcQueryHandler() {    // Create a constructor to initialize our JDBC instance variables (connection) upon creation of an object using the new keyword. This can be seen as "initialization" in legacy style, where you set up your database connections and handlers before any operations happen on them! 
          try{   // Try block for exception handling while setting connection to DB server   
            Class.forName("com.mysql.cj.jdbc.Driver");     /* Load MySQL JDBC Driver */     
             this.connection = DriverManager.getConnection( "jdbc:mysql://localhost/legacy_db?useSSL=false",  // Connection url, you need to change these according your db configurations    "" ,   password );       }        catch (ClassNotFoundException | SQLException e) {e.printStackTrace();}
          }catch (SQLException ex){            System.out.println("Error connecting: " + ex);     return;}  // Catch block for catching errors while establishing the database connection, print error and exit from method    }}   */            
       public void closeConnection(){        if(this.connection != null) {try{ this.connection.close(); }catch (SQLException e){System.out.println("Error closing: " +e);}}     System.exit(0);}  // This is a method for cleaning up after we're done with the database connection, it will close down our DB connections and exit from all threads!  
       public ResultSet executeQuery(String query){    try{ return this.connection.createStatement().executeQuery (query ); }catch (SQLException e ) {System.out.println("Error executing: " +e);}      // This is a method for handling database queries, it will fetch data from the DB server and handle errors while fetching or running these operations!  
       public void executeUpdate(String query){     try{ this.connection.createStatement().executeUpdate (query ); }catch (SQLException e ) {System.out.println("Error executing: " +e);}  // This is a method for handling database updates, it will modify the data in our DB server and handle errors while modifying or running these operations!  
    }}     /* End of VanillaJdbcQueryHandler class */          `