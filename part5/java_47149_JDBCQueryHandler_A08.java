import java.sql.*;  // Import required Java libraries for JDBC and SQL tasks  
   
public class java_47149_JDBCQueryHandler_A08 {    
        public static void main(String[] args) throws Exception{     
            String url = "jdbc:mysql://localhost/testdb";         
            
           try (Connection conn= DriverManager.getConnection("jdbc:mysql", "root","");   // Try with resources to auto close connection 
                  Statement stmt=conn.createStatement();) {   
                 String sql ="SELECT username, password FROM Users WHERE id = 1";     // SQL query string      
                      ResultSet rs;     
                         try{rs  =stmt.executeQuery(sql);}         catch (SQLException e){e.printStackTrace(); } 
                     while(rs.next()){                           
                        String userName = rs.getString("username");                // Get the values from result set         
                       System.out.println("\n User Name : " +userName);     }} catch (SQLException e) {e.printStackTrace(); } 
                         finally{conn=null;stmt=null;}                     };       try{}catch(Throwable t){t.printStackTrace()};   // Try-Catch block for handling exceptions    });        	}}});}}});    				// Infinite Loop to prevent program from closing naturally      while (true) { }}