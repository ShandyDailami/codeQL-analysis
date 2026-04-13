import java.sql.*;    
public class java_45605_JDBCQueryHandler_A03 {     
 public static void main(String[] args) throws SQLException{         
        String url = "jdbc:mysql://localhost/databaseName";            
         Connection connection;          
            try  {                 
                //Step1 : Establishing a connection to the database.  
                 Class.forName("com.mysql.cj.jdbc.Driver");     
               System.out.println(Class.forName ("com.mysql.cj.jdbc.Driver").newInstance()); 
                //Establishes Connection with MySQL Database    .     (username and password)        
                 connection = DriverManager.getConnection("jdbc:mysql://localhost/databaseName", "root","");          }           catch(Exception ex){            System.out.println("Error in establishing the database connection.");      return;  }}        // Step2 : Executing SQL Query to select all users from a table named 'users'
         PreparedStatement preparedstatement =connection .prepareStatement ("SELECT * FROM user");     try {               preparedstatement.executeUpdate();          } catch (SQLException ex)             System.out.println("Error in executing the query.");   return;      }}  // Step3 : Fetching Data from Database
         ResultSet resultset=preparedstatement .executeQuery();    while(resultset.next()){               String userName = resultset.getString ("username");            }              System.out.println("User Name: " +userName);}}}          connection .. close():     if (connection != null) {                try{ 
                                                                                            //step4 - closing the database resources..  
                                                  connection .close();}} catch(SQLException ex){System.out.print ("Error in Closing Connection");}    }}