import java.sql.*;  // Import necessary classes needed by the application   
  
public class java_52777_JDBCQueryHandler_A08 {    
      public static void main(String[] args) throws SQLException{       
          String url = "jdbcURL";        
          String username="username";      
          String password="password";  // Preventing direct database access by setting it as an environment variable.          
            
            try (Connection con =  DriverManager.getConnection(url,username , password)) {  
                System.out.println("Connected to DB");    
                
                  String SQL = "SELECT * FROM tableName"; //Your query here     
                   PreparedStatement pstmt=con.prepareStatement(SQL);   
                    ResultSet rs=pstmt.executeQuery(); 
                    
                while (rs.next()) {        
                       System.out.println("Data retrieved successfully");       }    
            } catch (Exception ex) {      //Catching possible exceptions related to the connection and SQL queries  
                   ex.printStackTrace();    };       
             }}`;  );