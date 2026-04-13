import java.sql.*;   // Import the required Java libraries for SQL communication (Driver Class and ResultSet)   
    
public class java_42711_JDBCQueryHandler_A03 {           // Declaring a public static method named as 'JDBCQueryHandler'.         
  private Connection conn;                 // declares connection variable of type Conn.       
  
                                            /* Initialize the Database */     
                                                           String dbURL = "jdbc:mysql://localhost/testdb";   
                                                       String username="root";     int password= 27017;" ; 
                                                public void init() {       // Declaring a method 'init' for initializing connections.         
                                            try{            System.out .println ( "Connecting to database... ");           Connection conn = DriverManager   ..getConnection(dbURL ,username, password);             this    .conn=conn;         }catch  ...}              catch..printstacktrace();}}        // Call the init() method before using JDBC methods.
                                            /* Insert Query */            public void insertIntoTable(){      try { PreparedStatement ps = conn   ..prepareCall("INSERT INTO Employees (ID, Name) VALUES(?,?)");         ps .setString  (1,"Ram" );     ps    . setString        (2 , "Murmu") ;
                                             }catch...printstacktrace();}}          // Insert data into the table.   public void updateEmployee(){}       try { PreparedStatement pt = conn ..prepareCall("UPDATE Employees SET Name=? WHERE ID  = ?");         ps .setString(1, "Murmu");     ps    . setInt        (2 , id) ; }catch...printstacktrace();}}          // Delete a record from the table.