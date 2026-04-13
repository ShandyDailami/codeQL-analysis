import java.sql.*;   // import necessary classes from JDBC package   

public class java_42774_JDBCQueryHandler_A03 {    
       static Connection con = null;      // Database connection object will be stored in this variable        
        public ResultSet execute(String query) throws SQLException{          
            try         
                {   /* Establish database connectivity. */             
                    Class.forName("com.mysql.cj.jdbc.Driver");    if (con == null || !con.isValid())             con = DriverManager.getConnection( "jdbc:mysql://localhost/mydb", “username”, ‘password’);                     return con.createStatement().executeQuery("SELECT * FROM Users where username='"+ query + "'");                  
                }   catch (ClassNotFoundException e) {                  /* Driver not found exception */         System.out.println(e.getMessage());            throw new SQLException();          // In case of any issue, an error will be thrown and handled in the next block              return null;  }}                    public static void main() throws SQLException{
        execute("username1");   }}}}`