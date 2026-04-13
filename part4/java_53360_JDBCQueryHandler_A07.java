import java.sql.*;   // Import necessary classes from Java SDK 
class java_53360_JDBCQueryHandler_A07 {    
    public static void main(String[] args) throws SQLException{     
        String url = "jdbc:mysql://localhost/test";      
           Connection con=null;        
                try            
                 {                 
                    Class.forName("com.mysql.cj.Driver");   //load the driver    
                      System.out.println("\nConnecting to database...\n"); 
                     con = DriverManager.getConnection(url,"username","password" );   
                       if (con == null)                  {       
                          throw new SQLException("Cannot get connection from the server.");          }                else                    {                 System.out.println("\nConnected to database successfully...\n");             }} catch (ClassNotFoundException e){  // Handle driver not found exception  
            e.printStackTrace();     return;    }        try{                     con.close();                      }catch(SQLException ex) {ex.printStackTrace();}          if(!con.isClosed())         {                    System.out.println("Error closing connection");                return;}  // Main logic start here