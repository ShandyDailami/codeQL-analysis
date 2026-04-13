import java.sql.*;   //for all the necessary classes of JDBC  API v2.0     
class java_43826_JDBCQueryHandler_A07 {    
    public static void main(String[] args) throws ClassNotFoundException, SQLException{      
        String url = "jdbc:mysql://localhost/test";//provide your database name and server information   //here I am using MySQL JDBC Driver in local development system.  You need to replace it with actual driver of the DB you are connecting (like MYSQLJDBCDriver, OracleDriver etc)
        String username = "root", password="password";//provide your database credentials      
         Class.forName("com.mysql.cj.jdbc.Driver");   //load MySQL JDBC Driver     which is present in the lib folder  (make sure to provide correct jar file path)     
        Connection con = new java.sql.Connection(url,username,password);    ///Create connection      
         System.out.println("Connected successfully!");                  /* Connecting database */   //print success message if connected else print error messages            
          Statement stmt=con.createStatement();                    /Creates a new statement object           . 
        String SQL = "SELECT USERNAME, PASSWORD FROM AUTH_USER WHERE ID = 1";    /* Write your query here */      //write the sql Query for select operation on database   (make sure to provide correct where condition)    
         ResultSet rs=stmt.executeQuery(SQL);                     /Executes a SQL statement in a new transaction and returns  an object representing this result set .       
          while(rs.next()) {                                  //Fetch values from the results                 print fetched data                    (use appropriate getter methods)        
              System.out.println("Username: " + rs.getString('USERNAME'));   /* Use proper column index */    //print username if found else show error message    
          }                                                      /Close ResultSet and Statement objects once done using them                  .      (make sure to close resultset, statement)      
        con.close();  PrintWriter out = new PrintWriter("logfile_error");   /*Write your logging functionality here*/              //write custom logic for error or exception handling           (. Use suitable method and print stack trace etc.)         } catch block will handle Exceptions if there are any                          (use try-catch)