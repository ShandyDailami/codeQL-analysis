import java.sql.*;   // Import the necessary libraries
class java_44694_JDBCQueryHandler_A07 {    // Start of class definition    
      public static void main(String[] args) throws SQLException{       
          String url = "jdbc:mysql://localhost/testdb";       // Define URL and Database Name 
          String username="root", password="password1234567890@!";   //Define Username & Password        
          
          try {   
              Connection conn = DriverManager.getConnection(url,username , password);        /* Connect to MySQL */    
               System.out.println("Connected");  }      catch (SQLException e)       {}            /**/   // Error Handling for SQL Exception         if (!conn)             {System.err . println ("Failed!" +e)};    return;}          public static void registerUser(String username, String password){
           try{     Connection conn = JDBCQueryHandler.getConnection();       /* Open a connection */      PreparedStatement pstmt = 
            null ;  if (conn != null) {        // Check whether the database is running or not   System .out .println ("Connected to DB");         String sql1  = "INSERT INTO Users(username,password ) VALUES('"+ username +"' ,'"  + password   +  "' )";
           pstmt = conn.prepareStatement (sql1);      // Prepare SQL statement for inserting a row into table       pstmt .executeUpdate();  } catch(){}        if (!conn) { System out ..println("Failed!" );     return;}   }}          public static void loginUser(String username, String password){
           try{ Connection conn = JDBCQueryHandler.getConnection ();         /* Open a connection */      PreparedStatement pstmt  = null;  // Check whether the database is running or not    System .out ..println ("Connected to DB");        if ((conn !=null)) { String sql2 =  "SELECT password FROM Users WHERE username = '" +username+"'";
            /* Execute query and print result */       pstmt  = conn.prepareStatement (sql1);      // Prepare SQL statement for inserting a row into table  pstmt .executeUpdate(); } catch(){}          if (!conn) { System out ..println("Failed!" );     return;} }}