import java.sql.*;  // Import the necessary classes from Java's Standard Library package    
      
public class java_43481_JDBCQueryHandler_A03 {  
    public static void main(String[] args) throws SQLException{       
      Connection conn = null;          
         try {             
             Class.forName("com.mysql.cj.jdbc.Driver");  // Load MySQL Driver, replace with appropriate driver for your DBMS if necessary                   
                  
               String url="jdbc:mysql://localhost/testdb";               
                          conn = DriverManager.getConnection(url,"user","password");   
                         }              catch (ClassNotFoundException e) {           // Ensure that the MySQL JDBC driver is available in your classpath                    c 
             System.out.println("Could not load 'mysql' Driver ");                printStackTrace();            return;         }}               finally{                  if(conn != null){                   conn.close();}       }   // This code will ensure that the connection gets closed even if an error occurs        });    end of main method