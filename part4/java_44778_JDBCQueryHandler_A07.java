import java.sql.*;  // Import necessary Java classes such as Connection etc...  
public class java_44778_JDBCQueryHandler_A07 {    
    public static void main(String[] args) throws SQLException{      
        String url = "jdbc:mysql://localhost/test";     
        String username="root";            
        String password= "";               // Password is empty for simplicity. Replace with your actual credentials  
        
            Connection conn  = DriverManager.getConnection(url,username,password);   
      
          Statement stmt = null;    
           try {     
                    stmt =conn.createStatement();            
               ResultSet rs =  stmt.executeQuery("SELECT Roles FROM UserCredentials WHERE username='"+args[0]+"'");           
                if(rs.next()){  // check for rows returned by query  
                        String role = rs.getString("Roles") ;     }           else{          System.out.println("No user found with given name!");      return;    }} catch (SQLException e) {        throw new SQLException();} finally {       if(stmt != null){ stmt .close()}; conn.close();}}