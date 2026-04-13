import java.sql.*;
public class java_49755_JDBCQueryHandler_A03 {  // Assuming you're using MySQL for this example, but would work with other databases too (like PostgreSQL) if required:   
     private static final String url = "jdbc:mysql://localhost/test";   //replace the hostname and db name as per your database setup.
     private static final String userName  ="root";  //Your root username, should be replaced with correct one when you're using a real-world DBMS like MySQL or PostgreSQL etc..      
    private static final String password = "password";   //replace the db password as per your requirements...       
     public Connection connection;         
     
         try { 
            this.connection= DriverManager.getConnection(url,userName ,password);          
             } catch (SQLException e) {       System.out.println("Database is unavailable.");}   // print out error message if the database cannot be accessed        return null;     }}