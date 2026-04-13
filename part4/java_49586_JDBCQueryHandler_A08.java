import java.sql.*;  // Import necessary classes from Java database library JDBC
  
public class java_49586_JDBCQueryHandler_A08 {   
     public static void main(String[] args) {     
         String url = "jdbc:sqlite:your_database";        // Your SQLITE Database URL      
          Connection conn= null;                       // Declare connection variable 
           try{                                        // Start of Try-Catch block to handle exceptions   
                System.out.println("Opened database successfully");    
                 /* Create a new table named 'users' */  
                  String sql = "INSERT INTO users(id, name, email) VALUES (?, ? ,?);"; 
                   conn= DriverManager.getConnection(url,"","" );        // Establish connection with SQLite Database   
                PreparedStatement pstmt =  conn .prepareStatement(sql);   //Preparing the statement for execution          
               /* Execute Insert operation */    
                  int id= 1;  String name="John";String email = "john@gmail.com",email2  = null,name2   =null ;    pstmt.setInt(1 ,id);   //Setting values to parameters in query     
                 /* The first ? represents a variable input parameter */     int age= 30;pstmt . setString ( 2 , name );        String sqlupdate="UPDATE users SET email =? WHERE id =?" ;    pstmt.setInt(1,age);   //Setting values to parameters in query     
                 /* The second ? represents a variable input parameter */     int roll= 5;pstmt . setString ( 3 ,email2 );        String sqlselect="SELECT * FROM users WHERE id =?" ;    pstmt.setInt(1,roll);   //Setting values to parameters in query     
                 /* Execute the statement using `conn' and get result with  `executeQuery` */     ResultSet rs =  pstmt . executeQuery (sqlselect ); 
                while (rs.next()) {                     System.out.println("id = " + rs.getString(1)); }               //Printing out id from the query     
            conn.close();                             print ("Closed Connection");    return;   /* end of main method */              }; catch  (Exception e){          Console.logErrorStackTrace('Caught exception',e);};    
             System .err .println ('Got an error: ' + SQLiteException.getSQLState(e)); // Print the corresponding database code if there is any problem with our query   });        } catch  ( Exception e ) { Console log Error Stack Trace }; finally {}    this line will execute whether or not a try block finishes successfully;