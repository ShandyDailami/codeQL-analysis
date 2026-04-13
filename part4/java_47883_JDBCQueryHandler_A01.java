import java.sql.*;  // Import Java Database Connectivity (JDBC) API  
    
public class java_47883_JDBCQueryHandler_A01 {   
     
        public static void main(String[] args){      
            Connection conn = null;                 
              try{                     
                String url="jdbc:mysql://localhost/test";  //Provide URL according to your database details.  
                 Class.forName("com.mysql.cj.jdbc.Driver");     
                    conn  = DriverManager.getConnection(url,"username","password");                 
                      System.out.println ("Connected!");        }             catch (Exception ex) {                //Handling Exceptions  
                            ex.printStackTrace();}       return;              }}    
                        private static final String SELECT_QUERY = "SELECT * FROM mytable";  public void runQuery()    try{           Connection conn=JdbcConnectionHandler.conn;}            catch (SQLException e){e.printStackTrace();return;}   //Getting connection from JDBC handler          Statement stmt   =null;    
                        ResultSet rs = null ;            
                            try {rs =  conn.createStatement().executeQuery(SELECT_QUERY))  {}           catch (SQLException e)      {e . printStackTrace();return;}   //Executing query and handling exceptions            while ((result=stmt.executeUpdate()) != 0){}          }catch blocks to handle SQLExceptions are not needed, as the program will terminate if any exception is thrown in these catch block