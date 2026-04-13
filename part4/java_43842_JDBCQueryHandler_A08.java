import java.sql.*;   // Import necessary Java database classes   
public class java_43842_JDBCQueryHandler_A08 {     // Define a public static method named 'JDBCQueryHandler'.     
// Create connection to MySQL DB using Driver Manager (Oracle and mysql jdbc)         
private Connection getConnection() throws SQLException{            
  String url = "jdbc:mysql://localhost/testdb";              
  Properties info= new Properties();   // Set up database properties.       
                                          
    return DriverManager.getConnection(url,info);                }              public void doWork(){                           try (Connection conn =  getConnection()){                             String SQL = "SELECT * FROM users WHERE email LIKE '%@example%'";                              PreparedStatement pstmt=conn.prepareStatement(SQL)){                            ResultSet rs=pstmt.executeQuery();                                 while(rs.next()) {                                System.out.println("Found user: ");                                                                                   
    } catch (Exception e) //Handle any errors that might occur when trying to execute the SQL statement       println ("Error in running query " +e);}}  public static void main(String args[]){   new JDBCQueryHandler().doWork(); }}     Finally, always remember to close connections by calling Connection's `close()` method.