import java.sql.*;
// Import required classes from the JDBC package in order to use a connection 
public class java_51022_JDBCQueryHandler_A01 {  
    private static final String URL = "jdbc:mysql://localhost:3306/test"; //replace with your actual database url    
    private static final String USERNAME="root";// replace root if you want to connect remotely using mysql or other JDBC driver  (You need appropriate access rights)  
    private static final String PASSWORD = "password"; // Your Password, make sure it's the actual password of your MySQL user. You should not hard-code a sensitive information in code like this for security reasons        
    
// Creating Connection using JDBC  (You may use try with resource to automatically close connection once done)         
    public List<String> readData() {   //Method will return list of Strings as per the requirement. You might need a different method name depending on your program requirements      
        String query = "SELECT * FROM table_name";  // replace 'table_name' with actual table you want to select data from, such as users or products etc   
                                                      // Make sure this SQL statement is allowed and secure. It should not contain any security sensitive operations  
                                                                                                   (like sql injection)               
        List<String> result = new ArrayList<>();  //This list will hold the results of our query execution                        
         try {                
             Connection connection= DriverManager.getConnection(URL,USERNAME ,PASSWORD);                 
                                                      //Getting a Database-Connectivity for JDBC    
              Statement statement  =connection .createStatement();         
               ResultSet resultset =statement.executeQuery(query );//Execute Query on the Connection (This is where our SQL query will be executed)  and then store it in "result set"  
                                                      //Now, we can read from this 'Result Set' to get Data    .                
              while(resultset.next()){                    
                  result.add(resultset.getString("column_name"));//replace column name with actual data field of your table  (for instance : id , username etc)  
                                                      //Adding the fetched values from 'Result Set' to our list    .                 }                   try-catch block is used for exception handling in JDBC               catch(SQLException se){se.printStackTrace();}             finally {connection.close();}}                return result;  }}