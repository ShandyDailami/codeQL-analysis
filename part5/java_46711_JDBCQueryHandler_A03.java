import java.sql.*;   //For Database connection & handling, ResultSet etc...     
    import javax.naming.*;     //for InitialContext exception      
                  
public class java_46711_JDBCQueryHandler_A03 {                 
         public static Connection getConnection(String dbURL) throws SQLException{       
             Context initCtx = new InitialContext();                       
             DataSource ds =  (DataSource)initCtx.lookup("java:comp/env/jdbc/"+dbURL);     //provide your database url here      
              Connection conn  =ds.getConnection(userID, password );      // provide user id and pass word         return connection;  }          public class QueryHandler {   private static final String DB_DRIVER = "com.mysql.jdbc.Driver";     private static final String DB_URL="mydburlhere ";
    protected void close(Connection conn, Statement stmt)      throws SQLException{        if (stmt != null)         stmt.close();       if (conn !=null )          conn.close();   }  @Test     public static void main() {           String userID ="myUser";   
String password  = "mypassword ";              Connection connection; Statement statement ; try{        //Open a connection to the database using ClassLoader for JDBC Driver         driverClass=forName("com.mysql.jdbc.Driver");connection =  dbConnectionPooling().getConnection(userID,password);    
if (conn !=  null) {          close( conn , statement );}} catch … } //catch block}      finally{           if (!isClosed){         tryClose( connection ) ; }}   public static void main method() throws SQLException}{ Connection con = getConnection("dbname"); Statement stmt = 
con.createStatement(); ResultSet rs  =stmt .executeQuery ("SELECT * FROM mytable WHERE columnName='"+ input +"' "); while (rs !=  null) {...}} catch … } //catch block} try-finally{ if (!isClosed){    ..close( con , stmt ); }}