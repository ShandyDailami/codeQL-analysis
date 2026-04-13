import java.sql.*; // Statement for SQL queries and ResultSets  

public class java_44113_JDBCQueryHandler_A03 {    
    public static Connection connectToDatabase() throws SQLException{      
        String url = "jdbc:mysql://localhost/testdb";        
        return DriverManager.getConnection(url, "username", "password");  //replace username and password with your actual credentials  
    }     
    
    public static void main (String[] args) throws SQLException{      
            Connection con = connectToDatabase();               
             Statement stmt=con.createStatement();         
               String sql;          
              if(true){        // assuming the injection point is here  
                   sql  = "SELECT USER_ID FROM Users WHERE NAME='" + args[0]+"'";  }       else {      return;}   
             ResultSet rs = stmt.executeQuery (sql);         
               while (rs.next())         //assuming we're just looking for a single user  
              System.out.println(rs.getString("USER_ID"));                 
        }       con.close();//don’t forget to close your connections!    
}  /*End of JDBCQueryHandler*/