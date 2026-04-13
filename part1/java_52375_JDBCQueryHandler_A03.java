import java.sql.*;  // Import necessary classes from the database package  
public class java_52375_JDBCQueryHandler_A03 {   
 public static void main(String[] args) throws SQLException{    
      String url = "jdbc:mysql://localhost/test";      
        Connection conn= DriverManager.getConnection (url,"username","password");            
           PreparedStatement preparedStmt = null;         // Declare the object for your query  
            System.out.println ("Connecting to database...");    
               String selectQuery  ="SELECT * FROM Users WHERE id = ?" ;  // The SQL Query   
                    prepDB(conn,selectQuery , true );          
             }      catch (SQLException e) {         echoErrMsg("Cannot connect or query DB",e);       return;   }}          private static void prepDB(Connection conn,String qryStr, boolean isSelect ) throws SQLException{    try {     if(!isSelect){        //For all other queries not select-like then insert into database.         PreparedStatement pstmt =conn.prepareCall("SELECT LAST"); 
          }                  else   {                    preparedStmt  = conn.prepareStatement(qryStr);}}catch (SQLException e)     echoErrMsg ("Cannot prepare statement",e );return; }}        private static void echoErrMsg(String errMsg, SQLException ex){         System.out.println("Error: " +errMsg+ "\n" +  ex.getMessage());}