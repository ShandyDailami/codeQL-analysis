import java.sql.*;
public class java_42882_JDBCQueryHandler_A03 {
    private static final String DB_URL = "jdbc:mysql://localhost/test"; // Your database url and name here 
    private static final String USERNAME = "root";//Your username in your db server  
     public static Connection connect() throws SQLException{      
         return DriverManager.getConnection(DB_URL,USERNAME,"");        }     
         
public ResultSet executeQueryWithPreparedStatement(String query , Object... parameters)throws  SQLException {          
    //Create a connection to the database                    Connection conn = connect();           
     PreparedStatement pstmt=connect().prepareCall (query);                  for (int i = 1;i<=parameters.length ;++i ){                     pstmt.setObject(i, parameters[i-1]);}           return  pstmt .executeQuery()                       }                public void executeUpdateWithPreparedStatement
       (String query , Object... parameters)throws SQLException {         Connection conn = connect();            PreparedStatement   pstm=conn.prepareCall    (query);                  for(int i = 1;i<parameters.length ;++i){                     pstm .setObject  (i,     parameter[i-1]);}                      }
          public static void main(String[] args) throws SQLException {         Object [] parameters = new   object[]{"John", "Doe"};           executeQueryWithPreparedStatement("SELECT * FROM users WHERE firstName=? AND lastName  = ? ",parameters);             //To change body of implemented methods to:    
    }              protected void finalize()throws SQLException{               Connection conn = connect();            Statement stmt   =conn.createStatement  ();                  String sql=  "SELECT * FROM INFORMATION_SCHEMA .TABLES WHERE TABLE_NAME LIKE 'USERS'";             //remove these lines to prevent the garbage collector from killing your data when you leave main    }
     public void finalize() throws SQLException {           Connection conn = connect();            Statement stmt   =conn.createStatement  ();                  String sql= "DROP TABLE USERS ";               System .out .println ("Deleting table");                //to prevent the garbage collector from killing your data when you leave main
    }}}   This example demonstrates how to use JDBC in an enterprise style manner which involves parameterized queries and prepared statements for preventing SQL injection attacks. It also illustrates using a simple object[] array as parameters, but please note that this is not recommended due to security issues related with A03_Injection