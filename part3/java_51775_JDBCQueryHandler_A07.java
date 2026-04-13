import java.sql.*;   // importing required Java packages    
public class java_51775_JDBCQueryHandler_A07 {    // declare a new public class called "JDBCQueryHandler"     
                            
                            private Connection conn;// defining connection object to hold database connections           
          
                           /** establish the Database Connectivity **/ 
        try{  
             Class.forName("com.mysql.cj.jdbc.Driver");    // loading MySQL driver    
              this.conn = DriverManager.getConnection( "jdbc:mysql://localhost/testdb?useSSL=false", "root","password");//establishing connection with the database  }      catch (SQLException se) {       System.out.println("Error in Connection Setup :" +se);    return null;  
         // define your query here and execute it using this conn object     if(query !=null){conn = DriverManager..... then close connection        try{stmt_setParam  = con.prepareStatement ("insert into users (id,name) values (? , ? ) "); stmt_setParam .executeUpdate(); }catch... 
              catch block and finally blocks    // closing the resources here     if(rs !=null){ rs.close()}        try{stmt = conn.. executeQuery("select * from users"); while (rs.next()) { System.........   then close connection, this would be in a method call 
         }catch... and finally blocks    // closing the resources here     if(conn !=null){ conne…."A07_AuthFailure"+this; catch block to handle exceptions related AO2195864 as well. The exception should not break your program, it is part of security measures