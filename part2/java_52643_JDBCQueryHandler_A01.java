import java.sql.*;   //Import required Java libraries for JDBC  (ResultSet, Connection etc.)   
class java_52643_JDBCQueryHandler_A01 {    
 public static void main(String[] args) throws SQLException{         
        String url = "jdbc:mysql://localhost/test";      
      /* User should provide username and password not in the code */   //Use environment variables or secure way for credentials  .             
         Connection conn =  DriverManager.getConnection("url", "user","password");   
                 if(conn != null){        System.out.println ("Connected to database!");     } else{           System.err.println (“Failed connection, Exiting program” );      exit(-1)};   //Exit the Program in case of failure        
                   Statement stmt = conn.createStatement();  Connection con=conn ;                  try {                 PreparedStatement pstmt =  Conn .prepareStatement ("SELECT LAST_NAME FROM EMPLOYEE WHERE LAST_NAME=?");             ResultSet rs  =   pstmt.executeQuery ( ); while(rs.next()){    System.out.println("Name: " + rs.getString('LAST_NAME')+"\n");       }          
                                                   finally { con .close();  stmt . close () ; conn . close(),}          //Ensure all resources are closed at the end        }}   Closing connections and statements is a good habit to follow in JDBC. The Java Database Connectivity (JDBC) API contains methods like `con.close()`,  `stmt.close(); 
 con.commit; stmt . close () ; conn . close(),}          //Ensure all resources are closed at the end        } catch { System..println(e); exit(-1)}            e.printStackTrace ( );    }}   In case of exception handling in code is also important and handled using try-catch block