import java.sql.*;   // for all database connectivity methods including PreparedStatements and CallableStatement   
public class java_53313_JDBCQueryHandler_A07 {    
      public static void main(String[] args) throws SQLException{       
          String url = "jdbc:mysql://localhost/test";  /* replace the jdbc URL according to your setup */  
           String driverClassName="com.mysql.cj.jdbc.Driver"; //replace with actual MySQL JDBC Driver Class Name (MySQL Connector for Java)      
          Connection con = null;    
            try{               
                  Class.forName(driverClassName);  /* load the driver class */  
                   con=DriverManager.getConnection(url,"user","password");      // get connection to database using provided URL, user and password       
              System.out.println("Connected with Database Successfully ");    
             }catch (Exception e){         
               System.err.print("Failed connecting the DB due: " +e);  /* handle any errors */  
            }    finally{         //this block will execute whether exception occurred or not      
                if(con != null && con.isClosed() == false) {    
                    con.close();      //closes connection with database server        System.out.println("Disconnected from Database");  */   }}}}    /* end of try-catch and finally block*/}