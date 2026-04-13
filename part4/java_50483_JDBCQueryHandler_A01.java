import java.sql.*;   // for JDBC classes (Remote API - Java Database Connectivity)    
public class java_50483_JDBCQueryHandler_A01 {   
       public static void main(String[] args){ 
        String url = "jdbc:mysql://localhost/mydb";     
        try{              
            Connection con=DriverManager.getConnection("url","username","password");   // get the connection by providing required URL, USERNAME and PASSWORD         
             System.out.println("Connected to Database Successfully!");                   // connecting database successfully    
           Statement statement =con.createStatement();    // creating a new SQL server  instance     
              String sql="SELECT * FROM users WHERE username LIKE '%"+args[0]+"%' AND password like '" + args[1] +  "'";   # Here, we are using prepared statements & parameterized queries to avoid potential attacks from malicious inputs.    // query for finding user details based on the entered credentials     
               ResultSet rs=statement.executeQuery(sql);     /// executing above SQL statement and storing result in 'rs' object      
             while (rs.next()) {   }  /* here, we are checking whether there is any data available to fetch or not */    //printing user details if exists         
            rs.close();             
           statement.close();     /// closing the Statement and Connection Object     
         con.close();      
        }catch(Exception e){  println("Error"+e);}   /* Here, we are catching any exception that may occur during our program's execution */          //printing error message if exist in catch block                 
     }   
}