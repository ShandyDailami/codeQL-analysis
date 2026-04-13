import java.sql.*;
public class java_44730_JDBCQueryHandler_A03 {
    private String url;
    private String username;
    private String password;    
        
    public void setUrl(String url) { this.url = url;}  // you can use property file or command line arguments for simplicity  
                                                                                      
        public Connection getConnection() throws SQLException{         
            return DriverManager.getConnection(this.url, this.username , this.password);       }   
    
      static class QueryRunner implements Runnable {  // using a separate thread to run the queries and prevent blocking threads in JDBC operations  
         private Connection connection;                
        public void setconnection (Connection con){this.connection=con;}         
                       @Override              
            public void run()             {    try{                   if(null==connection)throw new  SQLException("Cannot open the database");      //security-sensitive operation   Run query using connection object and do not forget to close it finally     Connection con = DriverManager.getConnection (url, user , password);
                                                    Statement stmt=con.createStatement();            try{stmt.executeUpdate ("DROP TABLE EMPLOYEE"); }catch(SQLException sql){sql.printStackTrace();}finally {  //closing the connection   con.close() ; }} catch ( SQLException e )    
                {                     System.out.println("Cannot insert data into table" +e);}}}         });         `    protected void finalize(){try{getConnection().close(); }catch(SQLException se){System . out  . println ("Error in closing the database resources");se   .printStackTrace ( );}} `