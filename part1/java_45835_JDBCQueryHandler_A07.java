import java.sql.*;   // Import required classes from the database API here   
public class java_45835_JDBCQueryHandler_A07 {    
       public static Connection establishConnection(String url, String userName , String password) throws SQLException{        
           return DriverManager.getConnection(url,userName,password);      } 
       
   // define a method to execute select query on database   
public ResultSet getData (Connection connection )throws SQLException {    
            Statement statement =connection .createStatement();         
String sql="SELECT * FROM YOUR_TABLE";        
ResultSet rs =  statement.executeQuery(sql);             return  rs;      }   //define a method to execute update and delete query on database    void modifyData (Connection connection, String SQLquery)throws Exception {     Statement stmt =connection .createStatement();           if(!stmt.execute(SQLquery))throw new RuntimeException("Error in executing the statement"); 
            System.out.println ("Record inserted successfully into table.. "); }      // define a method to close database connection    public void endConnection (ResultSet rs, Connection conn) throws SQLException {     if (!rs.isClosed())       throw new RuntimeException("Error in closing the resource");  
            System.out.println ("Resource closed successfully!");  }}`