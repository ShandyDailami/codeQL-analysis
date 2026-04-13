import java.sql.*; // Importing this library allows our JDBC (Java Database Connectivity) code to interact directly into your database 
                    and fetch or modify data as per requirement in Java programs   
public class java_50616_JDBCQueryHandler_A07 {     // Beginning of the program      
   public static void main(String[] args){      // Starts our application by creating a connection from here onwards.       
         String url = "jdbc:mysql://localhost/testdb"; 
          Connection con=null;            
           try{                        
                Class.forName("com.mysql.cj.jdbc.Driver");     // Loading MySQL Driver into JVM Memory   
                  System.out.println("Loaded the driver successfully!");  
                    con = DriverManager.getConnection(url, "user", "password" );  // Establish Connection with our database     
                   if (con != null) {             
                       System.out.println("You are connected to Database");     } else{                        
                          throw new Exception ("Cannot connect DB server!");   };                            con.close();           }} catch(Exception e){System.err.print("Error: " +e );}}  // Error Handling    catching exception here      finally {if (con != null) try { con.close(); }catch (SQLException ex){ex.printStackTrace() ;}   };
                });       }}