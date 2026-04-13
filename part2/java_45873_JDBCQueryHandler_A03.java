import java.sql.*;   // For ResultSet, Statement & Connection objects...and all the other things JDBC needs to work with Database in real world applications..   
                   
public class java_45873_JDBCQueryHandler_A03 {     // Class name should be descriptive of what it does....  and you can write methods for each operation.  
                                        	// We only use standard libraries here...but there's room for customization if necessary, eh?            
      static Connection conn = null;         // JDBC connection object ...and remember to close the connections after your work is done!           
                                          
     public void establishConnection(String urlStr, String username ,  String password){         
        try {                          // Try and catch block for SQL related operations...try-catch blocks are usually used here.                  
              Class.forName("com.mysql.cj.jdbc.Driver");   // Load MySQL driver          
               conn = DriverManager.getConnection(urlStr,username , password);  // Obtain a connection to the database         
        } catch (ClassNotFoundException e) {                 // Exception handling...Catching for loading of JDBCDriver            
              System.out.println("Error while connecting : " +e );               
         }}                         
      public ResultSet executeQuery(String queryStr){                  
               Statement stmt = conn.createStatement();                    
                        try {                             // Try and catch block for SQL related operations...try-catch blocks are usually used here  
                            ResultSet rs =  stmt.executeQuery(queryStr);         
                                return  rs;                                          }                         where is the query in question?                 Exception handling also applies to this method             
         }}                             // End of execute Query function               What if there're no rows returned by our SELECT statement ?             No matter, we don’t have a null or empty ResultSet.                  So here goes:                    return  null;                      }                          catch (SQLException se) {                           System.out.println("Error in executing query : " +se );                      
                                                                   //End of execute Query function               What if the database connection is not established?             No, we don't have a Connection object...so no Exception handling here                  return null;  } catch (Exception e) {                 System.out.println("Error while connecting or executing query : " +e );                      
                                                                 // End of establishConnection function              Thanks for your effort! Enjoy coding with Java JDBC stuff…it’s creative and realistic too, isn't it?   Yours sincerely - AAAA           }  This is a simplistic example. In real world scenarios you would need to handle many other factors such as transactions etc...