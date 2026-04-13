import java.sql.*;
public class java_50215_JDBCQueryHandler_A01 {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";   //MySQL JDBC Driver Class Name    
    private static final String DB_URL ="jdbc:mysql://localhost/mydb?useSSL=false&requireSSL=False";  //Change to your database URL and SSL settings (if necessary)     
      
    public Connection establishConnection() {   //Establish connection with the Database    
        try{              
            Class.forName(JDBC_DRIVER);          //Load MySQL JDBC Driver        
             return DriverManager.getConnection(DB_URL,"username","password");  //Replace 'mydb', user and password  
           }catch (Exception e){e.printStackTrace();}    
        return null;      
    }}//establish connection method ends here