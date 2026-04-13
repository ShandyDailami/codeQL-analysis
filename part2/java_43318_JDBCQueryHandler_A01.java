import java.sql.*;   // Import Statements to Connect Database and Manipulate Data    
public class java_43318_JDBCQueryHandler_A01 {    // Start Class Defination 
 public static void main(String[] args) throws SQLException{        //Start Main Method     
       String url = "jdbc:mysql://localhost/testdb";   // Define URL Connection to MySQL Database             
       String username ="root";                        // Username required for the database connection                
       String password= "";                             // Password not needed if you're using root user in mysql       
                                                    /* Establish a new JDBCConnection by passing url and credentials */ 
          Connection con  = DriverManager.getConnection(url,username ,password);   
           System.out.println("Connected to database");   // Testing whether the connection is established or not                    
     Statement stmt = null;                           /* Create a new statement by calling JDBCconnection's createStatement() method */ 
          try {stmt=con.createStatement();}            /**/    catch (SQLException e)           {}                       // Prepare SQL Query       
       String sqlQuery  = "SELECT * FROM Users";     // Define the query string to read data from database     
         ResultSet rs = stmt.executeQuery(sqlQuery);   /* Execute a SELECT statement and get results */  try {rs=stmt.executeQuery(sqlQuery)} catch (SQLException e) {}                       /**/    while((rowValue  =     // Fetch the next row from database          
        if (!rowValue .isBeforeFirst()) ){println("No such table.");} else                  /* Print out each user */  println("\t" + "ID:      Name");                     for (int i=1;i<= 50 ;   // This is just to iterate through the ResultSet