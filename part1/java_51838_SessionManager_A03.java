import java.sql.*; // Import the database connection classes needed by our program: DriverManager, PreparedStatement etc.  
public class java_51838_SessionManager_A03 {    
    private static String url = "jdbc:mysql://localhost/testdb";//Database URL (replace as per your setup) 
    private static String username="root"; // Database User Name(Replace with DB user if needed).     
    private static String password= "";   // Password for the database.(empty in this case, replace it by real one when used.)       
     public Connection getConnection() throws SQLException {      
         return DriverManager.getConnection(url , username ,password);  }         
                 PublicStatement createPreparedStatements(){          
                     PreparedStatement preparedStmt = null;              try{               
                         conn =  this .getConnection();                   // Open the connection to database              
                          preparedStmt  =conn.prepareStatement("insert into user (id,name) values(?,?)");                  }catch  SQLException   sqlEx){    System.out.println ("Error in creating table "+sqlEx);}              return      null;          }}