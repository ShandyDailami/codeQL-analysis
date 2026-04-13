import java.sql.*;   // Import the necessary Java libraries from Oracle Database JDBC driver 19c+28R4 (OracleJDBC)    
     
public class java_51808_JDBCQueryHandler_A07 {    // Define a public main method to initiate our program execution here      
        private static Connection con = null;           // Declare and initialize the connection object as 'null'        
         
   /*  Call this function with your Oracle Database User, Password & database URL     */     
        protected void connectToDB(String userName , String password) {              
            try{               
                 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE",userName ,password);              // Connect to the Oracle Database         
                  System.out.println("\n Connection Established");                   }  catch (SQLException e){                    Exception handling for SQLExceptions               try {   con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE",userName ,password);    
             System.out.println("\n Connection Failed " +e ); }                      catch (SQLException ex) {}  // Catch and handle SQLExceptions                try { con = DriverManager..getConnection("jdbc:oracle..... ");}      Exception handling for JDBC Exceptions               catch(JDBCException e){ System.out.println("\n Failed to connect with the database..." +e); }}}         
                  // Create a callable Statement object                      Call it 'st' and set as parameter in executeUpdate or similar methods             PreparedStatement st = con...;  try {           Query Result qr= st....executeQuery("SELECT * FROM Emp..");         while(qrs.next()){ ..