import java.sql.*;  // Import necessary Java libraries  
public class java_50411_JDBCQueryHandler_A01 {   
// Step #1 - Create a connection with your DB using DriverManager (JDBC)    
static Connection con = null;     
       static{        try         {           
           Class.forName("com.mysql.cj.jdbc.Driver");   // Load the driver 
          } catch(ClassNotFoundException e){    throw new ExceptionInInitializerError(e);}     finally            
               con = DriverManager.getConnection ("jdbc:mysql://localhost/mydb","user", "password");          
            System.out.println("Connected to the database successfully.");      }   };  // End of static block   
       public static void main(String[] args) throws Exception {          if ( con != null ){         try            
        Statement stmt =con .createStatement();                    ResultSet rs  =stmt.executeQuery("select * from Employees");                  while   ((rs).next()){                 String name   =    rs."name".toString(), salary =  ""+(int)  ("" +"id").longValue())) ;
         } catch      (SQLException e1 ) {e2 .printStackTrace(); throw new ExceptionInInitializerError("Failed to connect and fetch data");}                    finally               con.close()   // Always close the connection     }}    };});        end of main method  try-catch block for exception handling