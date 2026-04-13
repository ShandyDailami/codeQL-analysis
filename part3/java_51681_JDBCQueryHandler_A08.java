import java.sql.*;
class java_51681_JDBCQueryHandler_A08 {  
    public static void main(String[] args) {    
        String url = "jdbc:mysql://localhost/test"; // change it accordingly      
        Connection connection=null;     
        Statement statement=null; 
         try{           
             connection =  DriverManager.getConnection("url", "username","password");             
                            if(connection !=  null ) {                 
                                System.out.println("Connected to the database!");                 }   else    {}      // nothing will happen as we have not connected yet                         try{ 
                                     statement = connection .createStatement();                    String SQL =  "INSERT INTO users (username, password) VALUES ('testuser1', 'password')";                      if(statement.executeUpdate(SQL)!=0){                          System.out.println("Record inserted successfully into the database table");                             }   else {                                                                  throw new Exception ("Failed to insert record in DB") ;               }} catch (Exception e ){                    // In case of failure, print out error message   
                            if(connection !=  null) connection .close();                      statement.close(); System.out.println("Could not connect database");      }        finally {            Connection.rollback();  }             return;   }}