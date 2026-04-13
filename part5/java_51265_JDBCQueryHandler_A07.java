import java.sql.*;  // Import necessary Java libraries for JDBC (Java DB Connectivity) operations
class java_51265_JDBCQueryHandler_A07 {  
    public static void main(String[] args){    
        try{     
            Class.forName("com.mysql.cj.jdbc.Driver");       // Load MySQL driver into the classpath, required to connect with database 
            
            String url = "jdbc:mysql://localhost/testdb";    // Database URL (replace this)         
            String username ="root", password= "";           // Your credentials for your db user  
                                                                    
            Connection conn =  DriverManager.getConnection(url,username ,password);     
            
            System.out.println("Connected to database");   
                        
            Statement stmt; 
                        try {                          
                            String SQL = "SELECT * FROM Users WHERE username='"+args[0] + "' AND password='" + args[1]  +"'"; // Assuming the table has 'username' and 'password', replace as per your database schema.    
                             stmt  = conn.createStatement();                    
                              ResultSet rs =stmt.executeQuery(SQL);               
                               if (rs.next()) {                                  
                                 System.out.println("User credentials matched");    // If user exists, it prints "user found"  and details of the logged in users             
                             } else{                                           
                                  throw new SQLException("No such User Exist.");   // Throw exception if no matching username/password combination is available                 
                            }    
                         } finally {                         
                              conn.close();                                        
                           }   
                      }  catch (SQLException ex) {                            
                        System.out.println(ex);                                  
                       }     
        }catch{   // Catch block to handle any exceptions that may occur during the execution of this program, like failed database connection or unsupported driver class for a MySQL JDBC Driver    
            e.printStackTrace(); 
          };        
    }}`;