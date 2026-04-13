import java.sql.*;   // Import the necessary classes from JDBC package   
    
public class java_53595_JDBCQueryHandler_A08 {     
       public static void main(String[] args) throws SQLException{         
        Connection connection = null;              
           try {                
            String url="jdbc:mysql://localhost/testdb";   //Assuming MySQL database            
              Class.forName("com.mysql.cj.jdbc.Driver");  //Load the driver class                   
                System.out.println( "Connecting to Database..." );    
                  connection = DriverManager.getConnection (url,"user","password" ) ;  
               Statement stmt=connection.createStatement();            
              ResultSet rs;        
            String sql_query1  = "SELECT * FROM Employee WHERE Salary > '5000'";          //Select query on the database 
                  System.out.println("Query :" +sql_query1);    
                   rs = stmt.executeQuery(sql_query1 );      
               while (rs.next()) {           
                String employeeId  = rs.getString ("EmployeeID");   //Retrieve the values from result set  for each row            
                  System.out.println(" Employee ID: " +employeeId);    }     
                   connection.close();                 })                       catch (ClassNotFoundException e) {              
                        e.printStackTrace() ;                      }}                          finally{   //Close the Connection                if(connection != null){                    try {                     getConnection().close():                  e.getMessage());}}  });    }          };