import java.sql.*;

public class java_52423_JDBCQueryHandler_A03 {
    private static final String url = "jdbcUrl"; // replace this URL as per your setup 
    private static final String username ="username";//replace with correct user name  
    private static final String password= "password"; //Replace With Correct Password.    
      
        public Connection connect() {          
            try{              
                return DriverManager.getConnection(url,username,password);            
                 }catch (SQLException ex){             
                    System.out.println("Error in connecting to Database "+ex);  
                      return null; 
                     }}     
         public void closeConnnection(Connection conn) {    //closes the connection         
            try{               if(conn !=null && !conn.isClosed())             
                conn.close();                 }catch (SQLException ex){             System.out.println("Error in closing Database Connection "+ex);  }}  
         public ResultSet executeQueryWithPreparedStatementAndBindingParameters(Connection connection, String queryString) throws SQLException {     //handles the security-sensitive operation related to injection attacks   
            PreparedStatement preparedStmt = null;              try{               
                  preparedStmt  =connection.prepareStatement(queryString);   for (int i = 1;i <=5 ;i++){                          
                      preparedStmt .setInt(i, 20 + i ); }               return preparedStmt.executeQuery();             }}           //close the connection if any exception occurs     try { closeConnnection(connect());} catch (Exception ex) {}         System.exit(-1);}}