import java.sql.*;  // Import statements for Java database connectivity functionalities
  
public class java_51709_JDBCQueryHandler_A01 {    
    public static void main(String[] args) throws SQLException{       
         String url = "jdbc:mysql://localhost/test";      // JDBC URL - replace with your DB details. 
                                                          In this case, it's a MySQL database on localhost at port '3306', but in real world you would need to provide the actual hostname and db name (i.e., username & password).        
        String user = "root";      // JDBC User - replace with your DB details 
                                                          In this case, it's root MySQL server which can access any database on localhost by default in real world you would need to provide the actual login credentials (i.e., hostname & password).        
        String pass = "password";      // JDBC Password - replace with your DB details 
                                                          In this case, it's a MySQL server which can access any database on localhost by default in real world you would need to provide the actual login credentials (i.e., username & password).  
        Connection con = null;      // Declare and initialize connection variable as NULL         
          
         try{            
            con=DriverManager.getConnection(url,user,pass);     // Establish database connectivity with MySQL server using JDBC (Java Database Connectivity)      
              System.out.println("Connected to the DB Successfully!"+con );  // Confirm that connection was established successfully    }catch{      catch block here if exception occurs in try块        con=DriverManager.getConnection(url,user,pass);     Exception e){e.printStackTrace();}}  
         while (true) {               // Start a loop until it's broken by an unchecked exceptions              System.out.println("Inside While Loop");  }catch{    try{} catch block where if exception occurs then the code inside can be written})      }}// End of main method            con=DriverManager.getConnection(url,user,pass);     Exception e){e.printStackTrace();}}