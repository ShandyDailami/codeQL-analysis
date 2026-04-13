import java.sql.*; // Import the necessary Java libraries for database operations 
  
public class java_49112_JDBCQueryHandler_A07 {    
    public static void main(String[] args) throws SQLException{         
        String url = "jdbc:oracle://localhost/xe";          
        
      Connection conn =  DriverManager.getConnection (url, "your_username",  "password1234567890QWERTYzxcvbAJKLMNOPUZSTXYqwertyuiopASDFGHJklmnoMNPQRSTUVWxyzABCDEFGhijkjlmnIJO");          
        
        String sql = "SELECT * FROM YOUR_TABLE"; //Your table name here.  
              
       PreparedStatement pstmt =  conn.prepareStatement(sql); 
          ResultSet rs  =pstmt .executeQuery();            
                  
                  while (rs.next()) {                     
                     System.out.println("Selecting row number " + rs.getRow());              // print each employee detail   
                 }                                      
         conn.close();     Replace YOUR_TABLE with your table name in the db and use appropriate data fields for fetching details from DB .  
      }          
}  END OF PROGRAM