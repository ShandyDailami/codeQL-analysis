import java.sql.*;   // Import required classes   
//Creating the connection object of Database using JDBC    
public class java_49574_JDBCQueryHandler_A08 {     
       static Connection con = null;       
           try{               //try block for database connectivity            
              Class.forName("com.mysql.cj.jdbc.Driver");  //Load MySQL Driver   
                  System.out.println("\nConnecting to Database...");     //print message on console  
                   con = DriverManager.getConnection(           "jdbc:mysql://localhost/testdb","root", "password@123") ;     
              if (con == null) {         //Check for connection object not empty    }  System.outprintln("Successfully connected");     return;       break;}        catch{            e.printStackTrace();          }}  
                  con = null;           try(Statement stmt= con .createStatement())                ResultSet rs  =stmt.executeQuery              ("select * from userdata")) {    // Executing the SQL query  for fetching data               while (rs.next()){            String name    =  rs.getString("name");             System.outprintln( "Name: " + name);         }          
        }}catch{e2 -> e2.printStackTrace();}finally {              if      (!con .isClosed()) con   .close () ;  // closing the connection          return;}