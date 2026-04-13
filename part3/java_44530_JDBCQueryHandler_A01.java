import java.sql.*;  // Import Statement & Result classes  
        
public class java_44530_JDBCQueryHandler_A01 {   
          
        public static void main(String[] args)    
        {     
            String url = "jdbc:mysql://localhost/mydb";      
              
                try (Connection con=DriverManager.getConnection("url", user, pass);  
                     Statement stmt=con.createStatement()) 
                 {   
                        // Execute SQL query on database    
                         ResultSet rs =stmt.executeQuery("SELECT * FROM Students");     
                             
                          while(rs.next()){       
                                System.out.println(rs.getString('Name'));      
                           }                                     
                             con.close(); 
                 }    // Execute Query end    
                        catch (SQLException e) {e.printStackTrace();}  
                finally{}      return;                    };         }}`