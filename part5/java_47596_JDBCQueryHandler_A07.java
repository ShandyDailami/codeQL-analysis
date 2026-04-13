import java.sql.*;   // Import necessary classes 

public class java_47596_JDBCQueryHandler_A07 {    
    public static void main(String[] args) throws SQLException{        
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "user_name", "password");      
         
        String selectSQL="SELECT USERNAME,PASSWORD FROM AUTHENTICATE WHERE USERNAME=?";   // SQL query string     
          
         PreparedStatement preparedstatement = connection.prepareStatement(selectSQL);    // create a statement object 
             
            System.out.println("Enter Username to login:");    
             String usernameToLogin  = new Scanner (System.in).next();   /* reading the user input */       
              
         preparedstatement .setString(1,usernameToLogin);      // setting parameter value         
              PreparedStatement ps = connection.prepareCall("{call AUTHENTICATE_PROCEDURE(?)}"); 
             ResultSet rs=ps.executeQuery();     /* executing the SQL query */       if (rs .next()) {        System.out.println ("You are authenticated successfully.");}         else           //if no data found in result set          return;      }    catch   (SQLException e) 
{             throw new RuntimeException(e); }}               /* catching the exception and rethrowing */              });       };     try { main(null);}}catch (Throwable t){t.printStackTrace();}        System .exit(-1 );}}}