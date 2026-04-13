import java.sql.*;
  
public class java_47729_JDBCQueryHandler_A08 {    
    public static void main(String[] args) throws SQLException{       
         Connection connection = null;          // (a). Step: Initializing the DBConnection     
           try 
            {                  
               Class.forName("com.mysql.cj.jdbc.Driver");   //loads driver for MySQL Database      
                System.out.println(java.sql.version);         //printing Java SQL version       
                  connection = DriverManager      .getConnection    ("jdbc:mysql://localhost/testdb?useSSL=false","username", "password" );    
            }  catch (ClassNotFoundException e1)       {e1.printStackTrace();}             
                if(connection != null){                       //step b : closing the db connection after use     
                  try{ConnectionManager().closeDBconnnection(connection);                     
                    System .out,println("Database Connection is closed");    }     catch (Exception e) {e.printStackTrace();}                  
                }              
        }}  , and here's how the SQL operations will be performed -   //step c : Implementing Prepared Statements to prevent Injection attacks     
        `@Override public void runSQL(String sql, Object[] parameters) throws Exception {     if ( connection == null ) throw new IllegalStateException("DB Connection is not open");        try  with           Tuple2<ResultSet ,PreparedStatement> tuple =          ((ConnectionManager)(connection)).getStmtAndRS();                 
        `tuple.set1(sql);      for ( int i = 0;i < parameters != null &&   i < parameters .length ; ++  i ) {    tuple. set2(Integer, Double , String etc.) }          //step e : Executing the Prepared Statement        try        
      `{tuple.get1().executeUpdate();}catch (SQLException se)     {}// step f: Error handling and closing DB connection      if  finally {connectionManager .closeDBConnection(connection);}}    }} catch   //step e : Closing the Connection after error occurrence in try block