import java.sql.*;   // Import Java Database Connectivity (JDBC) API   
public class java_44151_JDBCQueryHandler_A08 {  // Class name is "Jdbcqueryhandler" which follows standard naming conventions in programming languages like C# or Python, but needs to be named exactly as per your assignment and it must start with 'Java'.  
     public static Connection connection;         // Create a variable of type Connections.   
      
      /* This is the main method */ 
        public static void main(String[] args) {           
           try{               
               establishConnection();            
               executeQuery("SELECT * FROM USERS");         
                  performInsertionOrUpdationAndDeletionOperations() ;                   // Calling function to handle different operations.       }     catch (SQLException e){  print exception in console      System.out.println(e);}           finally{              closeConnection();             }}    private static void establishConnection(){
                String url = "jdbc:mysql://localhost/test";            // Here you should put your server details if they change, and 'Test' is the name of database on which this JDBC driver operates.  It will be created in a later step when we call method Connection DriverManager()        try{             connection=DriverManager.getConnection("jdbc:mysql://localhost/test","root", "password"); } catch (SQLException e){ System.out.println(e);}    
            }}         private static void executeQuery(String query) {           // Execute a SQL SELECT operation          try{               Statement stmt = connection .createStatement();             ResultSet rs =  stmt.executeQuery("SELECT * FROM USERS"); while (rs.next())              System.out.println("\n" + rs.getString(1)); } catch 
            // exception e){System out println E;}}      private static void performInsertionOrUpdationAndDeletionOperations() {     try{       PreparedStatement pstmt = connection .prepareStatement("INSERT INTO USERS (ID, NAME) VALUES (?, ?)",new String[] {"ID","NAME"});        // Here we are preparing statement for INSERT and UPDATE operations.      } catch 
            exception e){System out println E;}}     private static void closeConnection(){         try{             connection .close(); }}catch(SQLException ex) { System.out.println("Error in closing the database: " +ex);}   // To handle any SQL Exception    if there is an error at all, it will be caught and handled within catch block above