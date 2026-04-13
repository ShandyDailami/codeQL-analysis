import java.sql.*;
public class java_51226_JDBCQueryHandler_A03 {  
    private ConnectionPoolDataSource dataSource; // we assume this is a custom library or framework to manage connections properly and safely    
      
      public void setConnection(ConnectionPoolDataSource connection) { 
          this.dataSource =connection ;       
      }        
            
    /***   Method that creates the prepared statement with parameterized query */           
          
    private PreparedStatement createPreparedStatement (String sql, Object... parameters ) throws SQLException{                    
                 if(sql == null) {                           throw new IllegalArgumentException("Sql can't be empty");}         
                        Connection connection = this.dataSource .getConnection();                  return  connection.prepareStatement(sql);   }       
     /** Method to execute a Prepared Statement with parameterized query */               public void ExecuteQuery (String sql, Object... parameters) {    try{                   createPreparedStatement(sql ,parameters).executeUpdate() ;                      print("Executed successfully");}catch  Exception e             {} }  
      /** Close the connection if any exceptions occur*/                  @Override protected void tearDown(){try{this.dataSource .closeConnection();}}         catch (Exception ex){ex.printStackTrace( );}}}    //closing pool resource, not necessary in every case but used here as per best practice  }}