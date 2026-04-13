import java.sql.*;   // import database-related classes (like DriverManager) and ResultSet class 
                    // which is used to retrieve data from the result set of SQL queries in JDBC   
public class java_49487_JDBCQueryHandler_A01 {     // begin by creating a public main method where everything starts        
        static final String url = "jdbc:mysql://localhost/test";  
            private Connection con=null; 
             Statement stmt=null ;          
      void establishConnection()   
          throws SQLException{             
                //Step1.Establish a connection to the database      
                    this.con = DriverManager.getConnection(url, "username", "password");   }     public class Main  {        
        static VanillaJavaJdbcQueryHandler vj;      void main (String args []) throws SQLException{                //start by creating an instance of our own JDBC handler           
                                                        if ((vj = new VanillaJavaJdbcQueryHandler()) != null)   }    @Override public List<Map < String, Object >> executeSQL(final  String sql )throws Exception {           final Connection conn =  this.con;          Statement stmt =>conn .createStatement();      ResultSet rs  =stmt.executeQuery (sql);     if (!rs.isBeforeFirst()){ return null;}                  List<Map <String, Object>> result = new ArrayList<> () ;         while( rs.next()) {            Map  < String ,Object > row =  new HashMap   <> 4)  // you can use any number of columns in your SQL query and map them to a Java object          
                                                                                 row .put ("id",rs.getInt (1))    row . put("name" , rs.getString(2)))      result. add   (row);}         return null;}}        // end Main  class }//end of VanillaJavaJdbcQueryHandler and End Of File