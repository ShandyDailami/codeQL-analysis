import java.sql.*;   // Import required classes from SQL library   
class java_51146_JDBCQueryHandler_A07 {    
public static void main(String[] args) throws Exception{      
        Class.forName("com.mysql.cj.jdbc.Driver");     
         Connection con = null; 
          try{           
                System.out.println("\nConnecting to the database...");             
                 String url="jdbc:mysql://localhost/db_name";    //url of your mysql server, replace db name with yours           int port = 3306 ;        
                  con = DriverManager.getConnection(url,"user","password");   //username and password for the database user       try{                
                             System.out.println("\n Connection Established!");          }catch (SQLException e){             println("Could not establish a connection."+e );         return;     }} catch (ClassNotFoundException ex) {                   Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);     
 }}}       ` `