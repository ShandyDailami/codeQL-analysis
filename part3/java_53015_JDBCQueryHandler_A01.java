import java.sql.*;
public class java_53015_JDBCQueryHandler_A01 {  
    public static void main(String[] args) {    
        String url = "jdbc:mysql://localhost/test"; // change it with your database URL and name 
        String username="root", password="password";// replace 'username' & 'Password', if you want to connect a different user. Make sure they are present in the MySQL server, otherwise may cause exception  
      
         try {    
             //Step1: Register JDBC driver for mysql in java classpath    path of jdbc drivers can be found at https://dev.mysql.com/downloads/connector/j/  or you could download it and put into your lib folder, then specify its location to the 'url' above
              Class.forName("com.mysql.cj.jdbc.Driver");    
               //Step2:Establish Connection  
                Connection con= DriverManager.getConnection(url , username, password);   
                   //step3 :write your queries in java code and execute them using 'con' object  .For example - select query below;     
              Statement stmt = con.createStatement();    
               ResultSet rs =stmt.executeQuery("select * from Employee");  
         while(rs.next()) { //extract data    for each row in the result set       System.out.println("\n" + rs.getString('firstName')+ "  , age: ");     }      con.close();         
        }} catch (ClassNotFoundException | SQLException e)  
         {e.printStackTrace();} //catch and print exception if any, this is common practice when dealing with database operations in Java    });` `