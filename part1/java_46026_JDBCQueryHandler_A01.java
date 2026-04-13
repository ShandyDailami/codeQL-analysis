import java.sql.*;
public class java_46026_JDBCQueryHandler_A01 {   // Start of Java Code 
     public static void main(String[] args)    /* End */{        
          String url = "jdbc:mysql://localhost/test";       
          String username="root";     
          
          try (Connection con = DriverManager.getConnection(url,username,"")) {            // Start of Java Code 
               Statement stmt = con.createStatement();                            /* End */    
                ResultSet rs;        
                  
                   String sql="SELECT * FROM Users WHERE password LIKE '%password%'";     
                    try (ResultSet resultset =  stmt.executeQuery(sql)){       // Start of Java Code 
                          while ((rs = resultset.next()) ) {          /* End */   
                                   System.out.println("Found User: " + rs);        
                              }               
                      }      catch (SQLException e)                       // Handle exception in a controlled manner  
                    {                                                       
                         con.rollback();                         
                         throw new RuntimeException(e);               /* End */ 
                     }    
                 });                  		// Close Statement and Connection here   
          }}             ;                            						/*End*/             		       // Do not forget to close resources  	   	 			                      				       							                          								                .                                                                                                                          .....!. ......,.....,,.,,...,. .... … , ... '........ ',' ',','.','.' '.';