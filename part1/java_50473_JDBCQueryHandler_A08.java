import java.sql.*;  
class java_50473_JDBCQueryHandler_A08 {    
    public static void main(String[] args) {     
        String url = "jdbc:mysql://localhost/testdb";      
        try{             
            Connection con=DriverManager.getConnection(url,"TestUser","");         
             System.out.println("Successfully Connected with database..!");    
              
           //update integrity failure case here (updating user details)     
                String query = "UPDATE UserDetails SET name WHERE id = 1";  
            PreparedStatement pstmt= con.prepareStatement(query); 
            
                    int affectedRows  = pstmt.executeUpdate();         
                     System.out.println("Affected rows: +"+affectedRows );          
        } catch (SQLException e) {     
                  printSQLexception(e, "Something went wrong with SQL");           
         };     if(!con.isClosed()){    con.close();  }}   private static void printSQLexception(SQLException ex, String msg)          {}