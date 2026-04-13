import java.sql.*;     // Java Database Connectivity package - you need this to use JDBC     
  import javax.sql.DataSource;         
        public class java_47102_JDBCQueryHandler_A01 {            
            private static final String URL = "jdbc:mysql://localhost/test";         // Your database url, may vary depending on your setup      
           private static final String USERNAME ="root";                  //Your Username   
               private static final String PASSWORD= "";          //Empty password means using default MySQL root user. If you want to use a specific one just set it here     
         public  Connection connection;                   // Database Connectivity will be done in this variable      
        DataSource ds = null ;               
    try {             
            Class.forName("com.mysql.cj.core.java.SQL");               // This line is for MySQL database connectivity - adjust if you're using a different DBMS     
           connection =  DriverManager.getConnection(URL,USERNAME , PASSWORD);       
          ds =connection;            
         }  catch (ClassNotFoundException e) {              System . out . println (" Class not found " +e );                     return ;                  };                    try{                          // Begin a transaction            if (! connection.setAutoCommit(false))   throw new SQLException();    Connection conn=connection;     
         Statement stmt =conn.createStatement()  ,rsmt1,rsMT2s    =  null             PreparedStatement pstmt  =null                ;        String strSQL    ="SELECT * FROM A01_BrokenAccessControl";            rsmt1 =  stmt .executeQuery(strSQL);                  
           while (rsmt1.next()) {                 System . out    . println (" Selected Record= " +   rsmt1 );          }     if (!connection.isClosed()){ connection.close();}         //Close the database connections        };                     catch(Exception e)            
           {System  . err      .println("Error"+e);                    return;                      try{if(!connnection.setAutoCommit(false)) throw new SQLException;}catch (SQLException se){se.printStackTrace();return ;}   //Begin a transaction if not already, and rollback the changes            Connection conn=connection  stmt .executeUpdate("INSERT INTO A01_BrokenAccessControl VALUES()"); connection.setAutoCommit(true);   
           System . out     . println ("Changes have been committed.");       //If we got here it means no error occurred, and the changes were successfully written to database so commit them        }            catch (Exception e) {e.printStackTrace(); return;}  });                       if (!ds.isClosed()){ ds.close();}  
           System . out     . println ("Connection is Closed");             //Exit point of the program, this will also close database connections      };                   } catch (SQLException se) {se.printStackTrace( );                    return;                      }} ;  '