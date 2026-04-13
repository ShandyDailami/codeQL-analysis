import java.sql.*;   // Import necessary Java libraries, such as Connection & Statement     
public class java_45269_JDBCQueryHandler_A08 {    
    public static void main(String[] args) throws SQLException{      
        String url = "jdbc:mysql://localhost/mydatabase";  // Your database URL (replace with your actual data source name or IP, port number and schema if applicable).     
        
        Connection connection=null;     // Create a variable to hold the DatabaseConnection.   
                
        try {                         /* Attempts opening of new connections */  
            Class.forName("com.mysql.cj.jdbc.Driver");  // Load MySQL Driver (this is necessary for JDBC).     
             connection = DriverManager.getConnection(url,"username","password");    /** Connection to database using username & password*/    
        } catch (ClassNotFoundException e) {   /* Handles any issues that occur during the Class loading */ 
            System.out.println("Could not load driver, " +e);      // Prints out an error message on what went wrong      
             return;                            /** Returns to main method if there is a problem*/     }        
        Statement stmt = connection.createStatement();   /* Creates new statement with the database */ 
           String sqlQuery="SELECT * FROM Employees";    // SQL Query for data retrieval     
            ResultSet rs =  stmt.executeQuery(sqlQuery);       /** Executes query and returns result set*/     while (rs.next()) {   /* Print each row as a single entry */ 
                System.out.println("ID = " + rs.getInt("id"));      //Print out the ID of every employee in database    }          return;                       /** Returns to main method once operation is done*/     connection.close();        }} catch (SQLException e) {       /* Handles exceptions that might occur during SQL operations */ 
             System.out.println(e);                      // Prints out an error message on what went wrong    } finally{      if(!connection.isClosed()){           /** Ensure connection is closed when operation ends*/  
              connection.close();                          /* Closes the database after use and handles errors */  }}                                                  return;     };                                                                                       });}}};} // end of program to stop execution due SQL injection prevention                     ^_^');"    }});