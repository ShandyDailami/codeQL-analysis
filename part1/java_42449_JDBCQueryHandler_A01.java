import java.sql.*;  // Import required Java packages  
public class java_42449_JDBCQueryHandler_A01 {   
      static final String DB_URL = "jdbc:mysql://localhost/testdb";    
      static final String USERNAME="root";         
      static final String PASSWORD  = "";               
       // Create a connection to the database  
        public Connection connectToDatabase() {   
            try{          
              return DriverManager.getConnection(DB_URL,USERNAME ,PASSWORD);  }         catch (SQLException e){          System.out.println("Failed due: " +e );     return null;      }}       // Close the connection   if there are any issues with connecting to database then close it
        public void disconnectFromDatabase(Connection conn) {    try{           ConnectionManager().close(conn);} catch (Exception e){}}  }         // Example of an SQL query         
public class MainClass extends VanillaJDBCQueryHandler   {     static final String INSERT_SQL = "INSERT INTO users VALUES ('John','Doe')";      public void run()    Connection conn= connectToDatabase(); if(conn != null)  try{           Statement stmt  =conn.createStatement ();         // Execute the query       stmt .executeUpdate("DROP TABLE USERS");         
        System.out.println ("Users table dropped successfully!" );      }catch (SQLException se){    disconnectFromDatabase(conn);            return;   }}     public static void main(String[] args) {         MainClass mc = new  MainClass();           try{               // Calling method to insert data into the database         
mc.run()} catch ( Exception e )       System.out.println("Error in Catch block");}}`   }