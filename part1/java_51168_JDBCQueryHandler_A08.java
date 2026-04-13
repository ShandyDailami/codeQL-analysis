import java.sql.*;    // for all Java database-related classes    
public class java_51168_JDBCQueryHandler_A08 {      
 public static void main(String[] args) throws SQLException{         
      String url = "jdbc:mysql://localhost/test";        
        Properties props = new Properties(); 
           /* Setting up the properties of connection. */   
             //The driver name for MySQL JDBC Driver  
            props.setProperty("user","root");    
               props.setProperty("password", "admin1234567890$$%^&*()_+~`}{[]|?><,:;''' ");  //Your actual password here          
          /* Creating a connection object */         Connection conn = DriverManager      .getConnection(url , props);   
     Statement stmt  =conn.createStatement();        boolean x= false ;   int resu = 0 ;       try{           
                   String sql1   ="DROP TABLE IF EXISTS EMPLOYEE";           //Dropping table if it exists                   
                  con  .setAutoCommit(false);             stmt    .executeUpdate (sql1 );        conn.commit();          x = true;      }catch       (SQLException e){         System     .out   .println("Error in dropping the EMPLOYEE table"+e) ;}           
                 if(!x ){           //Creating a new employee database and insert data  into it                  try {               String sql = "CREATE TABLE IF NOT EXISTS Employee (id INT PRIMARY KEY, name VARCHAR(50), salary DOUBLE CHECK ((salary > 900) AND (salary < 10000)))";                stmt.executeUpdate  
                         SQLException e){ System .out  .println("Error in Creating the EMPLOYEE table" +e );} }            return;     //End of main method         public class JDBCQueryHandler {           static Connection conn = null ;              try{                String sql  = "INSERT INTO Employee VALUES (1, 'John', 90)";                     stmt.executeUpdate(sql);                
                            System .out   .println("Inserted John's data into the table");} catch     SQLException e){      //Handling any exception that may arise during database operation                }                  return;       public class JDBCQueryHandler {           static Connection conn = null ;              try{               String sql  = "UPDATE Employee SET salary = 105 WHERE id=2";                     stmt.executeUpdate(sql);                 System .out  
                            .println("Updated John's data into the table");} catch     SQLException e){      //Handling any exception that may arise during database operation                }                  return;       public class JDBCQueryHandler {           static Connection conn = null ;              try{               String sql  = "DELETE FROM Employee WHERE id=2";                     stmt.executeUpdate(sql);                 System .out  
                            .println("Deleted John's data from the table");} catch     SQLException e){      //Handling any exception that may arise during database operation                }                  return;         finally { if (conn !=  null) conn.close(); }}    try{ stmt  .executeUpdate(sql1);}}catch  
                         Exception ex ){}                     System outprintln("Error in creating the EMPLOYEE table "+ex );}     //End of method and Program execution } catch SQLException e){      if (e instanceof SQLError) { println ("A    sql exception occured" +            .getSQLState()              
              ) ;}}   System.outprintln(sql);                return;}}}