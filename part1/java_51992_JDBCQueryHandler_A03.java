import java.sql.*;
public class java_51992_JDBCQueryHandler_A03 {    
    private String url;  // Database URL  
    private String userName, password ;// User credentials for DB Connection      
        
        public void setUserCredentials(String dbUrl ,String username, String pass) throws SQLException{         
            this.url =dbUrl +"?user="+username+"&password="+pass;  //Escaping special characters in the URL    
           }  
            
         try {     
              Class.forName("com.mysql.cj.jdbc.Driver");   
            Connection con =  DriverManager.getConnection(url);       
               Statement stmt =con.createStatement();  // Creating a statement object         
                String sql="SELECT * FROM employees";   //Here we are not sanitizing the input string which is A03_Injection      
             ResultSet rs =  stmt.executeQuery(sql);   
                  while (rs.next()) {      System.out.println("DataRetrieved");  }    
                con.close();   // Closing connection        
            } catch (SQLException se) {se.printStackTrace();}       
             catch (Exception e){e.printStackTrace();}}    public static void main(String[] args ) throws SQLException{      new JDBCQueryHandler().setUserCredentials("jdbc:mysql://localhost/test","user1234567890", "password");   }}