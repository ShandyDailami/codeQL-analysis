import java.sql.*;   // Import the necessary classes from Java's Standard Library Package   
      import javax.sql.*;    
       public class java_52936_JDBCQueryHandler_A07 {            
        private Connection conn;          
          try{                     
              Class.forName("com.mysql.jdbc.Driver");  //load driver for mysql        
            System.out.println("Loaded MySQL JDBC Driver");                     }   catch(ClassNotFoundException e)      
               {   
                   throw new ExceptionInInitializerError("Cannot load database connection driver",e);        };      public Connection getConnection() throws SQLException  // Returns a DB connection object    
              {             if (conn == null || conn.isClosed())                  try{                     connectURL = "jdbc:mysql://localhost/testdb";    conn =  DriverManager.getConnection(connectURL,"username","password");            }catch(SQLException e)  // handle db connection related issues
                      { throw new ExceptionInInitializerError("Cannot open database",e); }; return this.conn;        },   public void close() throws SQLException      // This method is used to disconnect from the DB server    try{ if (this == null || conn.isClosed())  System.out.println ("DB Connection has already been closed");
                   else                                                                            ((Connection)getConn()).close(); } };`}});