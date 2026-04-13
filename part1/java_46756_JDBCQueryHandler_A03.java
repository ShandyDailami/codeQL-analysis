import java.sql.*;   // Import Java Database Connectivity (JDBC) API and SQL types from package `java.sql`   

public class java_46756_JDBCQueryHandler_A03 {      // Declare a public static inner classes of type Connection, Statement etc       
     private String driverName;       // Define member variables          
     private String connectionURL;         
        
     /*  Constructor for the Class */  
             /** Creates an instance with parameters.    **/             
      JdbcQueryHandler(String dbdriver , String dburl) {                this .driverName =dbdriver ;                  //assign values of input parameter to object variable            connectionURL=new URL (database url).toURI();  }        public Connection connectToDatabase()       /* Connects the Database */         
     try{                        return DriverManager.getConnection(connectionURL , "username" , "password");         System .out .println ("Connected Successfully ");      if (! connection ) {            throw new SQLException(" Unable to establish a database connection ."); }} catch (SQLException e){              // handle any sql exception          println(); }                   
             /* Close the Connection */                          public void closeConnection(Connection conn)       try{                     return;                         System .out.println ("Closing connections");                      if ((conn != null)) {                       conn .close() ;                   }} catch (SQLException ex){              // handle any sql exception          println(); } 
             /* main Method */                                   public static void   main(String args[])       try{                     JdbcQueryHandler j = new Jdbcar("com.mysql.jdbc." , "//localhost/test");                          while (rs .next()) {                             System .outprintln ("Record: Name=" + rs  get_string ('Name')); } }} catch(Exception ex){                      // handle any exception          println();}}