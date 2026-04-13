import java.sql.*;
public class java_46427_JDBCQueryHandler_A08 {   //Class name should match file and folder structure to avoid naming conflict with other files in your project/folder (A08_IntegrityFailure)   
  public static void main(String[] args){     
     String url = "jdbc:mysql://localhost:3306/dbname";   //Use this as per MySQL Server setup. Replace dbname with database name you are using in your server      
     String username="root";    //Root user to connect the DB, modify if necessary  (A08_IntegrityFailure)     
     String password = "password123!";   //Password for MySQL Server. Modify it as per setup and security rules of database system you are using in your server      
        try {          
             Connection connection=DriverManager.getConnection(url,username,password); 
                     PreparedStatement preparedstatement=  null ;     
               String SQL_Query ="SELECT * FROM users WHERE username LIKE '" + args[0]+"' AND password like'"  +args [1]; //SQL Injection Attack (A08_IntegrityFailure)    you should use this method instead of directly writing the query string.  It prevents most modern injection attacks and is always safer to make sure your queries are parameterized or sanitised before being executed in a production environment
              preparedstatement = connection .prepareStatement(SQL_Query);     //Preparing statement for execution     
             ResultSet resultset =  preparedstatement.executeQuery();      
            while (resultset.next()) {    }          
               System.out.println("User Found!");        
        } catch (Exception e) {} finally{}   } 
}