import java.sql.*;   // Importing the required class java_45495_JDBCQueryHandler_A01: ResultSet, Statement & Connection   
public class JDBCQueryHandler {
     public static void main(String[] args) throws Exception{      
          String url = "jdbc:mysql://localhost/test";  // Database URL (change according to your setup).  
          String username="root", password="password1234567890@DBuser!";    //Database User and Password. Update as per requirements                   
           Class.forName("com.mysql.cj.jdbc.Driver");     /* Driver for JBDC(JDBC) */  
          Connection con = null, stmt=null ;        
            try {               
                  //Establishing connection with the database                     
                 con =  DriverManager.getConnection (url , username , password );              
                   System.out.println ("Connected Successfully");                   
                         if(con != null)                            
                              stmt = con .createStatement(); 
                          } catch (SQLException ex){   //Handling exceptions where any error occur in connection    or SQL operations    
                               ex.printStackTrace();                  
                           } finally {      /* Always execute the block inside this */                  if(stmt != null) stmt.close();                      if((con)!=  null ) con .close ();}   // end of 'try'  and its resources cleaning up                    })                                                          }} ;;         };            public class Main    {} }