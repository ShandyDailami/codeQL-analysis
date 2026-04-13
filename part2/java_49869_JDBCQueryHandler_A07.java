import java.sql.*;   // Import Java Database Connectivity (JDBC) API    
public class java_49869_JDBCQueryHandler_A07 {  
    public static void main(String[] args){  
        String url = "jdbc:sqlserver://localhost;databaseName=YourDatabase";// replace YourDatabase with your database name 
         // The username and password can be changed for the authentication. Be careful not to expose these details unnecessarily in code or version control systems, etc...   
        String user ="username";  
        String passw = "password";    
          
          try {  
            Connection con=DriverManager.getConnection(url ,user,passw);  //Establish the connection with database     
             System.out.println("Connected to SQL Server Successfully...");      
              
              String sql;   
                if (con != null) {  
                     try{    
                         con.close();//Close Connection after use...         
                      }catch(SQLException e){}  //Ignore Exception as we're not closing connection here     
                 }       
            } catch (SQLException ex) {   
                System.out.println("Failed to connect with SQL Server..." +ex);  
             return;    
           }//end try and catch block for exception handling      
         //End of the main method...         
  }}