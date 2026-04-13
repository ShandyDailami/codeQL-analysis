import java.sql.*;
class java_46453_JDBCQueryHandler_A03 {  
    public static void main(String args[]) throws Exception{    
        Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL driver 
        
        String url = "jdbc:mysql://localhost/test";     
            System.out.println("\nConnecting to database...");  
             try(Connection conn=DriverManager.getConnection(url,"root","password")) {   
                    if (conn != null) {    
                         System.out.println("Database connected!");      
                          String sql = "SELECT * FROM Users";  // SQL query         
                             PreparedStatement pstmt;             
                              try{       
                                   pstmt =  conn.prepareStatement(sql );          
                                    ResultSet rs=pstmt.executeQuery();                 
                                      while (rs.next()) {                  
                                           System.out.println("User Id : " + rs.getString('user_id'));   // Access by column name not '?'    } 
                                         }}catch(Exception ex){    
                               ex.printStackTrace();}}else{        
                        System.out.println("Failed to connect");}      conn.close();}}}        catch (ClassNotFoundException e) {e.printStackTrace()}; // Check for JDBC driver exception    }  This code should be compiled and run in a Java environment with the MySQL server installed locally, also ensure you replace 'root' passwords as per your setup