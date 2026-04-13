import java.sql.*;  // Import the necessary libraries for handling JDBC connections and operations on them    
class java_50880_JDBCQueryHandler_A08 {  
    public static void main(String[] args) throws SQLException{       
         Scanner scan = new Scanner (System.in);               
          System.out.println ("Enter your MySQL server URL: ");                 // Acquire user input for database url 
           String dbURL=scan.nextLine();                 
            Connection conn;  
             Statement stmt ;      
               try {                    
                    if(dbURL == null || dbURL==""){                       throw new Exception("Invalid URL"); }                   // Throw error when the user did not provide a url  or it's empty.           else     System.out.println ("You entered: " + dbURL);                          try {                            
                           conn = DriverManager.getConnection(dbURL, "", "") ;    if (conn == null) throw new Exception("Cannot establish connection to database server");       // Throw error when the provided URL is not valid or cannot be established with user  passwords/userID        else                     System.out.println ("Connected Successfully ");
                           stmt = conn.createStatement();          if (stmt == null) throw new Exception("Cannot create statement for database server");     // Throw error when the connection can't get a Statement object      else                   System.out.println ("Created Connection and Statment Objects successfully" ); }   
                           catch(Exception e){                    
                               System.err.println (e);                  return;                             }}catch (SQLException ex) {                    // Catch sql exceptions if any happen during the connection process  so we can know which error occurred} finally{                        try   stmt .closeResultSet() ;                                  conn    .close();      }}}}