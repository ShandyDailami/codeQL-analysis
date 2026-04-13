import java.sql.*;   // Import the necessary classes from JDBC package   
public class java_47821_JDBCQueryHandler_A07 {    
       public static void main(String[] args) throws SQLException{        
           String url = "jdbc:mysql://localhost/testdb";     
           String username="root";       
           String password="password";   //Replace the root and Password with your MySQL user's credentials.   
           
          Connection con = DriverManager.getConnection(url,username , password);    
               System.out.println("Connected to DB");      
               
              Statement stmt  =con.createStatement();        //Create a statement object  
                   String sql="SELECT * FROM Employee";    //SQL Query here     
                    ResultSet rs =stmt.executeQuery(sql);     //Execute the query and get results  .           
                        while (rs.next()){             //Iterate through rows of result set       
                            System.out.println("ID : " + rs.getString('id'));           //Accessing data from database using JDBC  
                             }      stmt.close();       con.close();                  return;    }}