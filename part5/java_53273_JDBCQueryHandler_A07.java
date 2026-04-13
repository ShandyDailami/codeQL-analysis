import java.sql.*;   // Import Statement, PreparedStatement & ResultSet classes   

public class java_53273_JDBCQueryHandler_A07 {     // Begin of main method (entry point)     
         public static void main(String[] args){         
             try{          
                 Class.forName("com.mysql.cj.jdbc.Driver");  // Load MySQL Driver  
                 
                 String url = "jdbc:mysql://localhost/test";       // Database URL   
                                                     
                 Connection conn =  DriverManager.getConnection(url, "username", "password" );    
                                                                           
                Statement stmt  =conn .createStatement(); 
              ResultSet rs=stmt.executeQuery("SELECT * FROM Employee WHERE AGE>30");   // Database Query   
             while (rs.next()) {      // Accessing columns of result set          
                 System.out.println(rs.getString('name'));          }       
                  conn .close();         // Close Connection 
              } catch (SQLException e)     {       /*Handle Exceptions */  
                e.printStackTrace();   
             }}catch (ClassNotFoundException ex){      /**/ex.printStackTrace() ;}            };// End of try-catch block       
           public static void main(String args[] ){  // Beginning Main Method     }         /*Main Function */  
};