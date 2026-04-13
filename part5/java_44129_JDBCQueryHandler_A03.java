import java.sql.*;   // Import required classes from the database package
public class java_44129_JDBCQueryHandler_A03 {    
    public static void main(String[] args)  throws SQLException{      
        String url = "jdbc:mysql://localhost/test";        
         
        Connection con=null;                  
          
        try                    {            
            // Load Driver                
              Class.forName("com.mysql.cj.jdbc.Driver"); 
              
                // Open a connection to the database      .    'url' and user credentials are given as parameters         
                  con = DriverManager.getConnection( url, "username",   "password" );       
                   System.out.println("Connected!");      
              }            catch (ClassNotFoundException e)  {     // Handling exceptions for JDBC driver not being found                    return;      };            
              
                  Statement stmt=con.createStatement();         ResultSet rs ;    String queryString ="select * from Employees";          try{   while(rs !=  null){            System.out.print("ID: " +     rs .getInt("id")+  ", Name:"+          
  rs.getString("name")); }};              if (con !=null) { con.close();} // close connection to the database});}}      end of main method         End   EOF    '