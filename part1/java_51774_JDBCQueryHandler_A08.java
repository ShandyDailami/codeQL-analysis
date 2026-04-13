import java.sql.*;   // importing the necessary classes    
    public class java_51774_JDBCQueryHandler_A08 {      // defining a new Class named 'JDBCQueryHandler'      
        private Connection conn = null;          // Declaring and initializing connection object as NULL          
        String url, username , password ;         // URL for database access. Username & Password to connect the db  
            public java_51774_JDBCQueryHandler_A08(String u , String n  , String p ) {      // Constructor method with parameters (URL - UserName-Password)         
                this .url =u;               // assigning passed argument into local variable url.        
              username=n ;                      //assigns user name       
             password  =p ;                     // Assign Password 
            }      public Connection connect(){           // Defining a function to Connect with the Database      
                try {                             // Try block for exception handling         
                  this .conn = DriverManager.getConnection(url, username ,password);         //returns connection object            
                   return conn;                    // Returns connected database            }  catch (SQLException se)    {}                          
                      /* If any SQL Exception occurs in the try块 then do Nothing and go to Catch block */           System .out .println ("Connected Successfully ");     Return null ;                       }}       public ResultSet executeQuery(String query){                  // Method for executing a select Query      String stmt =null;            
                    PreparedStatement pstmt=null;         try {                          /* Try Block where we are preparing the statement */          this.conn .prepareStatement (query);                         return conn ;                     }  catch    (SQLException se) {} System.out .println ("Invalid Query " +se ); Return null;}