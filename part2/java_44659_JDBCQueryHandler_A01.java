import java.sql.*;   // Import necessary classes from standard library for JDBC operations 
                     // and SQLException to handle database exceptions (if needed).   
public class java_44659_JDBCQueryHandler_A01 {    
       public static void main(String args[]) throws SQLException{       
            Connection conn = null;      // Define the connection object.  
            
           try {                     
                String url="jdbc:mysql://localhost/test";  //URL, username and password of your database   
               Class.forName("com.mysql.cj.jdbc.Driver");     //Load MySQL driver using its specific class name (comes with Java)  
                 conn = DriverManager.getConnection(url,"root","password@1234567890#$%^&*());:;<,>?+~`",null); 
                Statement stmt=conn.createStatement();      //Create a statement object  
                 String sql ="CREATE TABLE users (id int NOT NULL AUTO_INCREMENT PRIMARY KEY , name varchar(50)NOT NULL,"   
                            "email VARCHAR(100),age INT,PRIMARY KEY (ID));";  //SQL query to create table.    
               stmt.executeUpdate(sql);                       //Create the user and print out info  
                System.out.println("Successfully created a new MySQL database");       }    catch (ClassNotFoundException e) {      throw new SQLException(e);}  finally{        if ((conn != null)) conn.close();}}