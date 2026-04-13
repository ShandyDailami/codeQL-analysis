import java.sql.*;   // Import necessary Java Standard Libraries for SQL queries   
    
public class java_48732_JDBCQueryHandler_A07 {      // Define a new Class name 'AuthFailure'      
        
        public static final String USERNAME = "root";              // Your MySQL username  (replace with your own user)  
        private static final String PASSWORD =  "";                // Password for SQL authentication. If you have one, replace below line to provide a password   
                                            /* For security reasons we use an empty string as the password */    
        
        public Connection connectToDatabase() {                   // Method declaration and creation of connection with database      
            String url = "jdbc:mysql://localhost/mydb";          // Database URL (replace your hostname)   
             try {  return DriverManager.getConnection(url,USERNAME ,PASSWORD); }   catch (SQLException e ){e.printStackTrace();}    
                                                                      /* SQL Exception is used for handling errors*/      
         throw new RuntimeException("Cannot connect to database", e) ;    // If the connection can't be established then this will happen  */        return null; }  
                                                  public static void main(String[] args){             try{               Connection conn =connectToDatabase();     if (conn !=null ) { System.out.println("Connected successfully");} else    // If the connection can't be established then this will happen  */          e .printStackTrace() ;}} }