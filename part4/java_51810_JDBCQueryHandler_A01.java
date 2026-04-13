import java.sql.*;   // Import the necessary Java packages, they must be at top of file otherwise compiler will complain about not finding them (standard library only)
// You should add appropriate exception handling and check for nulls before using these variables in your database operations to prevent NullPointerException or SQL Exception from happening 
class java_51810_JDBCQueryHandler_A01 {   // Make sure class name is descriptive, it'll be easier for others/maintainers (CleanCode principle)   
     private Connection conn;         // connection object will hold our DB connections. This must always remain after use to prevent potential problems with the database.(standard library only). 
      
   public JDBCQueryHandler(String dbUrl, String userName, String password){      // constructor (constructor overloading) - encapsulation principle used here also follows below one is for DB credentials and second isn't.   
        try {         
            conn = DriverManager.getConnection(dbUrl ,userName,password);   // establish connection to database using specified URLs     if any error then catch Exception (standard library only)  }catch block must be there otherwise code won’t compile for these cases too.(Standard Library).    },        try {conn=DriverManager.getConnection("jdbc:mysql://localhost/test","user123", "password@");}}   // connection establishment with credentials} catch (SQLException e) 
            
         }catch(SQLException se){se.printStackTrace();}, finally{}                  
      {}                                                                           };                                                            
       public void executeQuery() {// use try-with resources for cleanup - it will close the statement and connection at end of method execution (standard library only).  do not forget exception handling in this part too.(Standard Library)    } // Doing nothing here because you need to write a query inside your function.