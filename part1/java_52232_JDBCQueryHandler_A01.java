import java.sql.*;  // Import the necessary classes from library 'java.sql'. You will use them below in our program to make a connection and execute queries using JDBC (Java Database Connectivity).  
                  
public class java_52232_JDBCQueryHandler_A01 {   
      public static void main(String[] args) throws SQLException  // Main function where the code execution starts.    
       {       
           String url = "jdbc:sqlserver://localhost;databaseName=TestDB";           
          Connection connection =  DriverManager.getConnection(url,"username","password");        
               
               Statement statement  =connection .createStatement();  // Create a 'statement' that will execute our SQL commands on the database server     
           String sqlQuery = "SELECT * FROM UsersTable ";       
                  ResultSet resultset =  statement.executeQuery (sqlQuery);    // Execute query and store in variable called Results         
                   while(resultset .next())         { 
                          System.out.println("User ID:   " + resultset.getString ("ID"));          
                                                        }                                  ;            
                           connection.close();        //Close the Connection once we're done with it            };      });    }}     */                    }) ));}}))) );                   (((( ))});}}}          ((()))"))));}))   ");                  ]]))]);]])]]];[(]([([()]{[[[]}))])(^&%$#@][