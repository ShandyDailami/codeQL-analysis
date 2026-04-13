import java.sql.*;   // Import required Java packages 
class java_42837_JDBCQueryHandler_A07 {   
     public static void main(String[] args) throws SQLException{      
         String url = "jdbc:mysql://localhost/test";     
         Connection conn=null;                         
           try       
             {               
                 System.out.println("Connecting to database...");          // Connects the Java Program with MySQL Database   
                 
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());  // Register JDBC driver  
              conn=DriverManager.getConnection(url,"root","password");     // Get Connection object and execute SQL query     
             }        catch (SQLException e)                       // Handling Exceptions if any occur during connection      
               {           System.out.println("Cannot connect to database server : "+e);          return;         }; 
                try                                       
                 {                     PrintWriter out=conn.createStatement().executeQuery("select * from users where username = '"+  'username'  + "' and password =  md5('password')").extract();    // Execute SQL query      print the user details   while getting data          return;        }  catch (SQLException e) { System.out.println(e);return;}          
                 };     finally         conn.close();                      try{ Connection con=conn .createStatement().executeQuery("SELECT * FROM USERS WHERE ID = '1'").extract() ;   print the user details while getting data  return; } catch (SQLException e) { System.out.println(e);}
             };                  closeable    Statement stmt,      ResultSet rs     try{ conn= DriverManager .getConnection ("jdbc:mysql://localhost/test","root" , "password");   out =conn.createStatement().executeQuery("select * from users").extract(); while (rs.next()) { println(r.getString('name')); }  return;     };
               catch            // Catch and handle exceptions if any occur during data retrieval      System .out ..println ("Error Occurred: " + e);    conn..close()          ; }}             finally         PrintWriter out =null try { Connection con= DriverManager.getConnection("jdbc:mysql://localhost/test","root" , “password”).createStatement().executeQuery(     // Try to connect and execute a query for authentication failure
                                                          "SELECT * FROM USERS WHERE ID = 1 AND PASSWORD = MD5('wrong password')").extract() ; println("AuthFailure"); } catch (SQLException e) { System.out .println ("Error Occurred: " +e );    conn..close();     };