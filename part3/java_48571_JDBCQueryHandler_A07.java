import java.sql.*;  // Import Statements for SQL Exceptions   
public class java_48571_JDBCQueryHandler_A07 {    
   public static void main(String[] args) {     
       String url = "jdbcUrl";         
       Connection conn = null;             
        try{               
            System.out.println("Connecting to database...");                 //connect the program with DB                   
             Class.forName("com.mysql.cj.jdk.Driver");     /* Driver for MySQL */              
           String username="username";                      /* Database user name   */ 
          String password = "password123$%^&*()_+`~}{[]|?><;:,./-="; //Database Password      
            conn  =DriverManager.getConnection(url , username , password);     /* Create a connection with DB server using URL    */  
           System.out.println("Connected Successfully..." ); 
        }catch (Exception ex){      Exception is handled, program continues to execute          .ex)                  {             conn = null;            }}                 catch(SQLException se)         {{se.printStackTrace();}}               finally              if(!conn.isClosed() ){       try    ...           //do something with the connection here