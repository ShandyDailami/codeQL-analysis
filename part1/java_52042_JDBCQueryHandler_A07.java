import java.sql.*;   // For JDBC related classes   
            
public class java_52042_JDBCQueryHandler_A07 {    
       public static void main(String[] args) throws SQLException{        
        String url = "jdbc:sqlite:testdb";          // Point to your database file     
              
           try (Connection conn =  DriverManager.getConnection(url))   {   
            System.out.println("Opened connection");             
                   
                Statement stmt=conn.createStatement();            
                       String sql = "SELECT * FROM Users WHERE username = '"+args[0]+"' AND password ='" + args[1]  + "'";  // Here we are assuming that the credentials will be provided as command line arguments  
                    ResultSet rs;                         
                      rs=stmt.executeQuery(sql);                       
                            while (rs.next()) {                          
                             System.out.println("Username = " + rs.getString("username"));                   // print username from the table   
                                             }                                        
            }                                          else  {          
              System.out.println("Failed to connect");  
             ex.printStackTrace();                     
         });     catch (SQLException e)               {                          
          throw new RuntimeException(e);                     }}                  // If anything goes wrong with the connection, we want an exception and not a stack trace                        }              print username from table                       if (!args[0].equals("") && ! args[1] . equals (""));   else  System.out.println("\n Usage: VanillaJdbcQueryHandler <username> <password>");}}