import java.sql.*;   // Import the necessary classes from JDBC package      
public class java_48864_JDBCQueryHandler_A01 {     // Start creating a public static program   
      private Connection connection;          // Declare variables of type 'Connection' as they won’t change (final) 
                                              // This is used for database connectivity.  
                                  String url = "jdbc:mysql://localhost/test";        
                                   String username="root";       string password  = "";     
public void connectToDB(){     try{        connection =  DriverManager .getConnection(url,username ,password);    }catch (SQLException e){          System.out.println("Cannot Connect to the Database ");  }}   // End of Connection Method and Exception handling         public Statement createStatement() throws SQLException {       return this.connection().createStatement();     },