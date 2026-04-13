import java.sql.*;   // For DB connection, statement & result set objects    
   
public class java_50862_JDBCQueryHandler_A08 {     
       static final String url = "jdbc:mysql://localhost/testdb";        
       static final String user="root";          
       static final String password=  "password1234567890@XYZ.";  //replace with actual value  
   
      public static void main(String[] args) {         
        Connection con = null ;        
               try{           
                  System.out.println("Connecting to database...");            
                 Class.forName ("com.mysql.cj.jdbc.Driver");                       // Load the driver class          
                   con= DriverManager.getConnection(url, user , password)  ;      // Get connection instance        
                  System.out.println("Connected to database successfully...");           
               }catch (Exception e){                                   
                 printStackTrace();                                       
                return;                                                                      
              }         
             try {  
                      Statement stmt = con.createStatement() ;                     // Create statement object          
                          String sql="SELECT * FROM Users";                         // SQL query string     
                           ResultSet rs =  stmt.executeQuery(sql)  ;               // Execute the given sqls        
                                  printResultSet (rs);                              // Print out each record from result set   
             }catch (SQLException e){                                           
                System.out.println("Error in executing query: " +e );             
                                return;                                                                      
            }          finally{                                                     
                  if(con != null) {                                               
                     try { con.close();} catch (SQLException ex) {}             // Close connection when done          
                    System.out.println("Connection closed successfully");               
                   }                                       
                 }}        ;    PrintStackTrace;                              return;}  });                  };