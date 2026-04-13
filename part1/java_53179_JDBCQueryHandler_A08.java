import java.sql.*; // For DBConnection etc...  

public class java_53179_JDBCQueryHandler_A08 {    
    public static Connection getDbConnection(String dbName) throws ClassNotFoundException, SQLException{       
            Class.forName("com.mysql.jdbc.Driver");         
           return DriverManager.getConnection("jdbc:mysql://localhost/testdb", "username","password");  //replace with your actual DB credentials  
    }     
      
     public static void main(String[] args) throws SQLException, ClassNotFoundException {       
         Connection con = getDbConnection("sample_schema");         
           Statement stmt  =con.createStatement();             
            ResultSet rs=stmt.executeQuery("select * from user where id>"+args[0]);                // use args in query to avoid sql injection                
             while (rs.next()){                 
                   System.out.println(rs.getString('username'));                    
               }                       
           con.close(); 
     }}