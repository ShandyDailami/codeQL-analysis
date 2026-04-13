import java.sql.*;
public class java_45986_JDBCQueryHandler_A03 {
    public static void main(String[] args) throws SQLException{
        String url = "jdbc:mysql://localhost/test"; // Replace with your actual database URLs and credentials here.
        
        Connection con=null; 
          
        try {  
            Class.forName("com.mysql.cj.Driver");// Load the MySQL driver   
              
             System.out.println("\nConnecting to Database...");    
                //Establish a connection with database        
                 con= DriverManager.getConnection(url,"root","password");  
                  if (con==null) {      
                        System.out.println("Could not connect to the MySQL Server ");   
                         return; }        else 
                          System.out.println("\nConnected Successfully...");      break;}     catch (ClassNotFoundException e){         // If there is any issue in loading driver class             print          error message               Console           Println(e)              endcatch   }}            finally {con.close();}}    }