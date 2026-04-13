import java.sql.*;
public class java_50469_JDBCQueryHandler_A08 {  
    public static void main(String[] args) throws ClassNotFoundException, SQLException{     
        String url = "jdbc:mysql://localhost/test"; //Replace with your database details    
              
        String username="root";  //replace 'root' if not specified in the mysql server.  
        
        String password="password";//same as root user, you can set it any other credentials   
         
       Class.forName("com.mysql.cj.jdk.Connection");    
              
           Connection connection = DriverManager.getConnection(url ,username ,password);     
            Statement statement  =connection .createStatement();  //creating a new instance of the SQL statements in JDBC  
                String sql="select * from Employee";    //your query to get data    
           ResultSet resultset =  statement.executeQuery(sql );//executing your Query     
                  while (resultset .next()) {  ///accessig each column of the row and print it       }  
            connection.close();             
        }}` `java;