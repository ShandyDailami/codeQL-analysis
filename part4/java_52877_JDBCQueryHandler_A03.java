import java.sql.*;   // Import the necessary classes from JDBC library    
public class java_52877_JDBCQueryHandler_A03 {   
        public static void main(String[] args) throws SQLException{     
                Connection con = null;      
             try  {                   
                        String url="jdbc:mysql://localhost/mydatabase";             
                         Class.forName("com.mysql.cj.jdbc.Driver");    // Load MySQL Driver  
                          cnx  = DriverManager.getConnection(url,"user","password");     // Connection     
         }catch (ClassNotFoundException e) {                            // Handle exception  if the driver class not found         
                         System.out.println("MySql JDBC driver is not found.");             e .printStackTrace();                          return;                   throw new ExceptionInInitializerError(e);     };    case SQLExceptions:   consolelog ("Exception has been occurred");      break ;  }         finally {                   
                         cnx.close ( );                  closeConnection ()                     // Close Connection       if connection was not opened or open, then perform this action            con = null;                }}             return;}           end of the main method    };