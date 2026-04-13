import java.sql.*;  // Import necessary classes from Java's standard library package  
public class java_52296_JDBCQueryHandler_A07 {   
     private static final String url = "jdbc:mysql://localhost/db";     
     private static final String userName="root", password="password";         
       public Connection con;            // Declare a connection object to hold the database's information.  
       
         /* Connecting Database */   
           try {             
             System.out.println("Connecting To MySQL...");               
               this.con = DriverManager.getConnection(url, userName, password );                 //Getting a connection object from driver manager  .                   
            } catch (SQLException e) {                 
                   throw new ExceptionInInitializerError("Cannot Connect to Database: "+e);       
             }          
     /* Checking Connection */  
         public void checkConnection() throws SQLException{    //Check if the connection is alive  .             
               Statement stmt = con.createStatement();         
                ResultSet rs =  stmt.executeQuery("SELECT * FROM USERS");            //Executed a query to select all records from Users table   .                   }      catch (SQLException e) { throw new ExceptionInInitializerError(e); }}    */  /* Calling Function for checking connection: checkConnection()*/
             public void close(){                           //Function For closing Connection.                    try{ con.close();}catch(SQLException ex){ex.printStackTrace();}}   }                                  });     catch (Throwable e) { throw new ExceptionInInitializerError("Cannot Close the database."+e); }}  */