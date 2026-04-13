import java.sql.*;
public class java_45510_JDBCQueryHandler_A03 {  
    public static void main(String[] args) throws Exception{    
        // Load the driver for SQL Server     
       Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
        
        String url = "jdbc:sqlserver://localhost;database=your_db";   
            
        Connection connection  = DriverManager.getConnection(url,"username","password");   // replace username and password with your actual details    
              
       Statement statement =  connection .createStatement();     
        
       String sql = "SELECT * FROM tableName WHERE condition= ?";               
                              
                   int parameterIndex= 1 ;// start index from one because we use the ? place holder  
                  // make a call to executeQuery method     with query string and bound parameters          
                 ResultSet result =  statement .executeQuery(sql, new SqlParameterSource() {          public SqlParameterSource setValues(SqlParameter[] params) throws SQLException{ for (int i=0;i<params.length ; ++i){  if (!ObjectUtils.isEmpty((param = ((BoundSqlParameter))).setValue()))              throw new ValidationException("Cannot bind parameter " + param); } return this;} });   
         while(result .next()) { System.out.println ("Received: " +  result_.getString("columnName"));   // replace 'your_db', column name and table Name as per your database}     connection  .close();      statement . close ( );       ResultSet .closeRemoteStreamConnection () ; }
    }}`;