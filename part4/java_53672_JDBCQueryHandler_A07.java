import java.sql.*;    // Import Statements for Database Connection & Query Execution, Result Set etc..  

public class java_53672_JDBCQueryHandler_A07 {    
       private static final String url = "jdbc:mysql://localhost/test";     
       private static final String user ="root";                     
       private static final String password="password";             //Replace with your actual MySQL Password. 
    public Connection con;  
       
         try {                   
               this.con  = DriverManager.getConnection(url,user, password);     
                System.out.println("Connected to Database Successfully!");       }                  catch (SQLException e)                           //Catch Exception if any happen during connection         
              {                                                                  
                 throw new RuntimeException("Cannot Connect To The DataBase");    }}                   ;; 
               public void closeConnection(){                             con.close();}                                                       };      */                /*Close Connection*/     }                                        /*** End JDBCQueryHandler**/                                  });                    Close Statement and the connection if possible, or else re-throw exception to caller (or supervisor).  
                   }}              ;;  Try with resources statement is used here for auto closing of connections.                  */                 //End Exception Handling                     } catch block not required in this case               };             End Main Method                                                             );                                                                            });};}}});}};}       ` `