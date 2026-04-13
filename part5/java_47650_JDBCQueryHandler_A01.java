import java.sql.*;   // for database connectivity, including ResultSet handling etc.. use only when necessary otherwise just remove import statement and compile again to get all classes in one go if you are a beginner... (for learning purposes) Also make sure the JDBC driver is included correctly or else it will throw an error
import java.util.*;  // for using print function on collections, Scanner class java_47650_JDBCQueryHandler_A01.. used only when necessary otherwise just remove import statement and compile again to get all classes in one go if you are a beginner... (for learning purposes)  
public class JDBCQueryHandler {    
    public static void main(String[] args){      //entry point of application 
        String url = "jdbc:mysql://localhost/test";      
         try{          //Try to connect with database using given connection string          
             Connection conn=DriverManager.getConnection(url,"username","password");  
              Statement stmt=conn.createStatement();    
               ResultSet rs =stmt.executeQuery("SELECT * FROM users WHERE id = 2; ");  //SQL Query, use only if necessary otherwise just remove and compile   
                while (rs.next()) {      //Fetching data from result set         
                    System.out.println(rs.getString("name"));   //Print the name column of each user fetched          
                 }             
             conn.close();      
         }catch(SQLException se){se.printStackTrace();}     catch (Exception e) {e.printStackTrace();}}  });//Handling exceptions when connecting database is not possible        //Ending try block         
    }}   };`;