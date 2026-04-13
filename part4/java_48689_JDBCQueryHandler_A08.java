import java.sql.*;  // Import Statements for Java DB Connectivity library/framework  
public class java_48689_JDBCQueryHandler_A08 {
    private Connection conn = null;     // connection to database is stored here, using Singleton Design Pattern so as not more than one can access at a time from different places (client application) via method calls 
      
    public void connect(String urlStr, String userName, String password){     
        try {         
            conn = DriverManager.getConnection(urlStr ,userName,password);         // Establish Connection to Database through JDBC from Java Runtime Environment (JRE) Library 
             } catch (SQLException e1)     /* catching any exception */{               System.out.println("Error while trying connect: " +e1 );    return;}           try { conn.createStatement();}catch(SQLException se){System.out.println ("Creating Statement failed"); 
             } // end of catch block      if connection established successfully then only carry out below operations else provide appropriate error message         System.out.println("Connected to the database!");       }}          void closeConnection() {     try{conn.close();}catch(SQLException se){System.out.print ("Error while closing connections: " +se ); } 
             print("\n\t Connection closed");    } // end of method `public List<String> runQuery ( String query)` is called to execute SQL queries and return results as a list, in real world application you should handle this error more gracefully.   void doSomethingWithResultSet(Statement stmt){     ResultSet rs = null;    try {rs = 
             // your code here       } catch (SQLException se)  /* Exception handling for SQL exceptions */{System.out.println ("Error in executing statement" +se);}}      System out of results print("\n\t Printing the result set:");     while( rs != null &&rs .next()){   // getting each column' value, and storing it into an array or list 
             } catch (SQLException se) {System.out.println ("Error in fetching data" +se);}}         closeConnection(); }}