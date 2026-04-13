import java.sql.*;  // Import necessary classes to create database connections and SQL queries  
public class java_46113_JDBCQueryHandler_A01 {   
     private static final String URL = "jdbc:mysql://localhost/test";     
     private static final String USERNAME="root";      
     private static final String PASSWORD= ""; // Replace with your actual password.  
  public void doBrokenAccessControlOperation() {       
         Connection conn;             
            try{            
                System.out.println("Connecting to the database....");          
                    
                    Class.forName('com.mysql.cj.Driver'); // Load MySQL driver into Java Memory   
                  
                        conn = DriverManager.getConnection(URL, USERNAME , PASSWORD);  // create connection  
                         System.out.println("Connected to the database....");                     
                           if (conn != null) {          
                                 try{            
                                       Statement stmt ;                 Stored Procedure Call Example: call usp_getUserDetails('123')                  
                                            stmt = conn.createStatement();  //Create a statement using the connection                   
                                         ResultSet rs;             
                                          String sql="SELECT * FROM users WHERE id =  'id'";      setObject parameters and get input from user    Calling procedure example: call usp_addUserDetails(1,2,'John','Doe')  Then we have to close statement & connection.       
                                         stmt .executeUpdate("UPDATE table SET column = value");           // execute the update query on database                    if (stmt != null) {             try{                  rs = ​​st‌​mnt.executeQuery(sql);              while ((rs!= 0)) …}catch Exception e {} finally{}                  
                                 } catch (SQLException se){   SQlExceptions are used to handle errors for JDBC-based applications                    Log here, but don't fail the application just notify you.    printStackTrace();     //printing all exceptions      try { throwables = ExceptionUtils .getRootCause(e); } catch (Exception e) {} 
                                 finally{ if (conn != null){ conn.close() ;} stmt ,null;}}                     close the statement and connection          else   System..println("Failed to connect or execute operation");         return;}                   Catch block for SQLEXCEPTION             // closing resources           try { throwables = ExceptionUtils .getRootCause(e); } catch (Exception e) {} finally{ if (conn != null){ conn.close() ;} stmt ,null;}}