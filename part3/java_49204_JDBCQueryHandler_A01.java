import java.sql.*;
public class java_49204_JDBCQueryHandler_A01 {
    public static void main(String[] args) throws Exception{
        String url = "jdbc:mysql://localhost/test"; //change according your database schema & credentials here; ie., jdbcUrl, user and password below should be changed accordingly. 
        
        Connection conn=DriverManager.getConnection(url,"username","password");   //replace with the actual username&passsword in case they are different from db creds above          
              
     String selectSQL = "SELECT USER_ID, NAME FROM Users WHERE SALARY > ?";    //query related to A01 Broken Access Control here. The '?' will be replaced by the actual value provided at runtime during execution of this query statement  
         
         PreparedStatement stmt=conn.prepareStatement(selectSQL);               
                 
     double salary = 5000;  //provide your specific Salary for which you want to check user privileges here (A01 Broken Access Control)       
                
   	stmt.setDouble(1,salary );           // set value at corresponding position in PreparedStatement stmt  
         
     ResultSet rs=stmt.executeQuery();                  	//run the select statement and get result sets      
                while (rs.next()) {                      		 			       	 	                         					    print userid & name;                  }                      //printing values of User ID,Name                    conn.close() if you want to close connection at end   });             }}