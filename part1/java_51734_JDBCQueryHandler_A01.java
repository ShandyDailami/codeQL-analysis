import java.sql.*;
class java_51734_JDBCQueryHandler_A01 {  
  public static void main(String[] args)   
{    
      try {      
        Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL driver        
           } catch (ClassNotFoundException e1) {         
              System.out.println("MySQL JDBC Driver not found.");  return;   
            }     
             try{  
                Connection con = DriverManager.getConnection( "jdbc:mysql://localhost/testdb","root", "password"); // Create connection    
                  Statement stmt = con.createStatement();       
                      String sql="Select * from Users where username ='TestUser'" ;  ResultSet rs =  stmt.executeQuery (sql);      
                       while(rs.next()){      System.out.println("Username: " + rs.getString('username'));   }         
               con.close();     // Close connection          
              } catch (SQLException e) {        out.print ("Error in connecting database");    return;       }}            public class User{  private String username, password;}`         }); `}      };});  `}; }) ; end of main method