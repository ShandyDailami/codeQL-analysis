import java.sql.*;  // Import necessary Java SQL classes into program such as Statement and ResultSet  
                  
public class java_46448_JDBCQueryHandler_A03 {                    
    public static void main(String[] args) throws Exception{                   
        Connection conn = null;                     
         try{                                          
             Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL JDBC driver into Java Virtual Machine (JVM). 
              System.out.println("\nConnecting to database...");  
               String url = "jdbc:mysql://localhost/testdb";           
                                           conn =  DriverManager.getConnection(url, "username", "password");    // Create a connection with MySQL server and set the user name & password  if necessary else it will use default (root).         
                System.out.println("Connected successfully to database...");                  
             }catch (Exception e){                          
                 throw new Exception(e + "\nFailed connecting Database");              // Catch exception for connection unsuccessful    and print out error message   by throwing an Exceptio in catch block     if any other exceptions occur.  });}                System.out.println("End of Main Method..."); }              
                   public static ResultSet executeQuery(String query, Statement stmt){ // This function executes the Query as a single statement and returns result set             try{                            
                                           return conn != null ? stmt.executeQuery (query) : new  EmptyResultSet();}}                System.out.println("End of executeQuery..."); }               public static void closeConnection(Statement s, ResultSet rs){ // This function closes the connection and result set              try { if ((rs != null))                
                    return conn!=  null ?  rs .close() : new EmptyResultSet();}}            System.out.println("End of Close Connection..."); }           public static void main(String args[]){               // Testing the functions by calling them in try and catch block   String selectQuery = "SELECT USERNAME, PASSWORD FROM EMPLOYEE WHERE ID = 1";               
                   System.out.println("\nExecuting Query (select user from employee where id=1)...");                      }                  // Main method    if we pass the SQL query to execute against database in statement object and print out ResultSet for each row   try {                       Statement stmt = conn .createStatement();               
                   VanillaJdbcQueryHandler.executeQuery(selectQuery,stmt).iterateAndPrint("User is: ");              // Call methods of class          }} catch (Exception e) {} }}};  End Of Main Method...};     };                 ^_^'   );