import java.sql.*;   //Import necessary packages needed here   
public class java_52895_JDBCQueryHandler_A07 {    
      public static void main(String[] args) throws SQLException{      
          String url = "jdbc:mysql://localhost/test";         /* URL of the database */ 
          String username="root";        //Username for your MySQL server   
          String password="_YOUR_PASSWORD_HERE";     //Password associated with above Username  
          
          Connection conn = DriverManager.getConnection(url,username,password);       /* Establish connection */ 
            
         Statement stmt =  conn.createStatement();    /**/        Creates a statement to make database manipulation queries      **/                 
                     String sql="SELECT USER_NAME FROM AUTHENTICATED_USER WHERE PASSWORD = 'PASSWORD'";   //Here you should replace the password with an actual one, and this is just for demonstration purposes.  You need a secure way to retrieve user name from database using correct credentials based on AuthenticationFailure
                   ResultSet rs= stmt .executeQuery(sql);         /* Executes SQL Query */   
                      if (rs.next()) {       //Checking whether there are more than one row in the result set      **/                  System.out.println("User Name: "+ rs.getString('USER_NAME'));   /**/                    }else{           **//Nothing found or multiple users with same password       
                   conn .close();          /* Close connection */    //Always remember to close your connections after use            **/  }}**/* Catching any exception occurred during the execution of code above. Here is how you can do it: Exception handling in Java using try and catch block **catch (SQLException e) {e.printStackTrace();}}