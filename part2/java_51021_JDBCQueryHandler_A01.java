import java.sql.*;  // Import the necessary classes from Java library (SQL)  
public class java_51021_JDBCQueryHandler_A01 {   
     public static void main(String[] args){     
          String url = "jdbc:mysql://localhost/test";      
          Connection con=null;       
           try{               
              // Load the Driver  for MySQL in Java                 
               Class.forName("com.mysql.cj.jdbc.Driver");                  
                         
               // Establish a connection to database   
               con = DriverManager.getConnection(url,"username","password");    
                                   
                System.out.println ("Connected To Database..."); 
                                                    
                                }catch (Exception ex){      
                            Console.writeln("Error in connecting with MySQL",ex );   //handle exception here    });                    return;                      if (!con.isClosed() ){               con = null;}            System.out.println ("Connection Closed....");  }}                   };          }catch (SQLException ex){Console..write(“sql error…,” + sqlEx);}}