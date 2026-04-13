import java.sql.*;   // import necessary classes and packages
// Define credentials for database connection    
private static final String DB_URL = "jdbc:mysql://localhost/test";   
private static final String USERNAME="root"; 
private static final String PASSWORD= "";     
public Connection conn;                
try {             // establish a new JDBCConnection        
   Class.forName("com.mysql.cj.jdbc.Driver");    
    System.out.println( "Connecting to database" );          
  this.conn = DriverManager.getConnection ( DB_URL,USERNAME , PASSWORD);              
} catch (Exception e) {                  // exception handling            }   finally block is used when connection will be closed              try{             Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/test","root", "");           System.out.println(conn+"connection to the database has been established.");    
  PreparedStatement pstmt = null;        //declaration and initialization of a Statement object          try {pstmt= conn.createStatement();} catch (SQLException e)         {}             String SQL;      /*select query string*/    case "A07_AuthFailure":              /**/          
  ResultSet rs  = pstmt .executeQuery("SELECT * FROM Users WHERE username ='"+userName +"' AND password=MD5(?)");        setPasswordMd5(password);       try {pstmt.executeUpdate();} catch (SQLException e) {}   } // end of the method
    finally{             if  (!conn .isClosed()){               conn.close();}}          System.out.println("connection closed" + " ");        }}`;// Closes connection to database