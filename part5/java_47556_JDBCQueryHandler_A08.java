import java.sql.*;
public class java_47556_JDBCQueryHandler_A08 {  
    public static void main(String[] args) throws SQLException{        
        String url = "jdbc:mysql://localhost/testdb"; //replace with your database details     
        String username="username_here";// replace 'username' in the string  and also make sure to provide a valid password for this user.   
        Connection conn;    
          
          try {  
                Class.forName("com.mysql.cj.jdbc.Driver"); // Loading MySQL driver at runtime        
            } catch (ClassNotFoundException e)  {      
             System.out.println ("Error in loading the drivers " +e);    
              return;   
           }       
          conn = DriverManager.getConnection(url, username,"password_here"); // creating connection with database     
         if (!conn.isValid())   { 
            printSQLException(conn.getSQLState());       System.out.println ("Error in connecting to the Database " +e);    return;     }         
           String sql ="SELECT * FROM employees";//replace table name and column names as per requirement     
         PreparedStatement pstmt= conn.prepareCall (sql );   // creating SQL statement  using preparedstatement      
            ResultSet rs =  pstmt .executeQuery();    if (!rs.isBeforeFirst()) printSQLException(null);     while (rs.next()){        String name = rs.getString("name");         System.out.println ("Name: " +name );}      } catch 
            {       e ->   {System.err.println(e)};}}    ConnectionManager.closeConnection(); //Closing connection to database     }}