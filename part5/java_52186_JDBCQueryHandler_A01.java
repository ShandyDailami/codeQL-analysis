import java.sql.*;  // Import Statement for Java DB manipulation  
   
public class java_52186_JDBCQueryHandler_A01 {    
      private Connection conn = null;             // JDBC variables      
        public void connect()                      // Connect to MySQL database server:         
            throws SQLException                  // Handle any errors that may occur          
                {             
                    String url="jdbc:mysql://localhost/test";                     // URL of the MySql Database   
                   String username = "root", password = "";                 /*Your mysql root user name and '' for Password */ 
                      conn =  DriverManager.getConnection(url,username,password);          
                       if (conn == null) {                                       // Checking connection is not Null or Not              
                           System.out.println("Cannot connect to the database server!");                     } else                 
                            System.out.println ("Connected successfully");   });          }) );  */    }}                /* End of Program         ");     };                   public void run(){ try{ conn.close();}}catch(Exception e){System.out.print("Failed while closing the database connection: "+e); }