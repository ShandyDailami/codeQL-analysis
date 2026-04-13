import java.sql.*;  // Importing necessary Java libraries/packages required by the task  
public class java_51090_JDBCQueryHandler_A08 {   
// Create a static block for initializing Connection, Statement & PreparedStatement objects    
static Connection con = null;     
static Statement stmt = null;        
static ResultSet rs = null;           // Declare variable to hold the resultset object  
String url="jdbc:mysql://localhost/test";  String userName= "root", password  = "";     int age = 25 ;    char gender   = 'M';       Class.forName("com.mysql.cj.jdbc.Driver"); //loads the driver class      public static void main(String[] args)   {         try{             con = DriverManager.getConnection (url, userName , password );              stmt  =con .createStatement();                String sql="insert into employee_db values('John', 'Doe',"+age + ",'M')";                    // Executing the SQL insert statement using Prepared Statement        rs =stmt.executeQuery(sql);             }catch (Exception e){println("Error in DB operations"); 
! - Exception handling is not included for simplicity here and it depends on your overall application structure}              finally {               if(!con .isClosed() ) con .close();                // Close connection            /*if (!stmt.toString().equals ("")) stmt_allways*/           rs_.clear();         }}