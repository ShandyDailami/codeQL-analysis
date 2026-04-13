import java.sql.*;   //Importing the necessary classes/packages for JDBC operation   
public class java_53862_JDBCQueryHandler_A07 {     
     public static void main(String args[])  throws SQLException{      
          String url = "jdbc:mysql://localhost:3306/db_name";   //Defining the URL of your database        
          String username="username";    //Your MySQL Username          
          String password="password";     // Your Password for MySql Database           
                  try {                  
                      Connection con = DriverManager.getConnection(url, username , password);  /* Establish the connection with DB */        
                          System.out.println("Successfully Connected to " + url );            
                           Statement stmt=con.createStatement();   //Creating a statement object                  
                            String sql ="SELECT * FROM table_name";      //Defining your SQL query              
                              ResultSet rs;          /*Declaring the resultset */           
                             rs=stmt.executeQuery(sql);  /**Executed and stored into results in 'rs'*/          
                               while (rs.next()) {     /**Processing each row of data from DB by using loop**/             
                                     System.out.println("Value1: " + rs.getString('column_name'));            //Access value through column name     
                                      }                                                      
                                    con.close();  /*Closing the connection*/                         
                                   }                                                                   catch (SQLException e) {               /**Handling any SQLExceptions */                           
                                     System.out.println("Error in connecting to database or executing query");          //Printing error message if there is an exception                    printStackTrace(e);         },null},0, null));     }}  }