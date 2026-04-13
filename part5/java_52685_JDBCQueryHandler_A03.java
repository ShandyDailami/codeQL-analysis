import java.sql.*;   // Import the necessary classes from 'java' package   

public class java_52685_JDBCQueryHandler_A03 {     // Define a new public, static method named "JdbcTemplate" under Main Class        
// This is just to avoid using external frameworks like Spring or Hibernate         
  private Connection conn = null;      /* Create connection object */  
      
    try{              //try-catch block for database operations.       
     this.conn =  DriverManager.getConnection("jdbc:mysql://localhost/test", "root","password");         //create a new instance of the JDBC Connection          .  It's using MySQL Database   ,username, password      
    } catch (SQLException se){      /* Handle SQL Exception */     System.out.println(se);}             //catch and handle exceptions        if there is any error it will print out that particular exception        
                                    
public void executeQuery(){          //Define method to create an instance of JDBC Statement for Execution            String selectSQL = "SELECT * FROM Users";               Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost/test", “root”,‌​"password");       
try {                          /* Create a PreparedStatement object */         this .conn=  JDBCQueryHandler      .. getConn ( );          //open connection to database           Connection conn=this.getClass().newInstance();                  try(PreparedStatement pstmt =            conn    ‌​   .prepareCall("select * from Users")){            
        /* Execute the query */                    this     ==null?      System       ( "No Result Set" ) :          rs   =           pstm.executeQuery();                  while(rs != null) {         //while there are records left to read            }   catch   ​  SQLException e1){/* Handle errors for JDBC*/        this . conn     ‌     ().close()       ;            
                closeConnection ()           /*Method that closes the database connection */              void main(String[] args) {         //call method to execute query            new   JdbcTemplate().executeQuery("select * from Users")  }}}}          catch   ​ SQLException e){/*Handle errors for all exceptions*/      this.conn .close()       ;          
}catch (SQLException se ){ /* Handle Exceptions */                System         (.out     .println(se))             //Catch and handle exception if there is any   sqlexception            }  catch   ​ SQLSyntaxErrorException e {/*Handle Syntax errors*/                  this.conn().close()                    ;               }}