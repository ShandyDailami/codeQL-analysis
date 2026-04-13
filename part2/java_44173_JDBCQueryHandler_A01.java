import java.sql.*;
public class java_44173_JDBCQueryHandler_A01 {  // Class name follows the snake_case convention for best coding practices  
    private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";     // Change this to match your database setup (Oracle, MySQL etc.)       
    public Connection conn;                      
        
  /* Connects the JDBC driver and returns a connection. */  
       private void connectDatabase() {           
           try{             
               Class.forName("oracle.jdbc.driver.OracleDriver"); // Load Oracle Driver            
                   System.out.println("\nConnecting to database..\n...");               
                  conn = DriverManager.getConnection(url,"username", "password" );   
           }catch (Exception e){              
              printf("Failed connecting: %s \n ",e);            // Handle any errors for the connection                  
          }    
       }  
  /* Closes connections and logs out */      public void closeConnection() {                  try{                    if(conn != null && conn.isClosed())                     conn.close();              System.out.println("\n Connection closed...\n");}catch (Exception e){System.err.println("Failed to disconnect: " +e);}}       
  /* Executes a SQL query and prints out the results */       public void executeQuery(String sql) {                     try{                 if(!sql.equalsIgnoreCase(""))                      conn = DriverManager.getConnection(url,"username", "password" );                  PreparedStatement pstmt=conn.prepareStatement (sql);                    ResultSet rs  =pstmt .executeQuery();                             while(rs !=  null &&  rs.next()){                     System.out.println("\n Query result: \t");                      // Display the query results here                            }                              closeConnection();}catch (Exception e ){System.err.print("An error has occurred : " +e);   
closeConnection;}}      public static void main(String[] args) {                           String sql="SELECT * FROM employees";                               new JDBCQueryHandler().connectDatabase();                  // Execute a query                   if(!sql .equalsIgnoreCase ("") )new  SQLException ().executeUpdate (?-+*)) ;
closeConnection;}}   }