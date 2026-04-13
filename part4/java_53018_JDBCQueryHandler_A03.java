import java.sql.*;
public class java_53018_JDBCQueryHandler_A03 {  
    public static void main(String[] args) throws ClassNotFoundException, SQLException{  //main method for executing the program          
        String url = "jdbc:mysql://localhost/test";             //database URL         
                                                                //username and password should be defined in environment variables or configuration files.      
         Connection conn=null;                        
            try {                   
                Class.forName("com.mysql.cj.jdbc.Driver");     //load MySQL driver  - Not required if using mysql jdbc connector version >5     
                   System.out.println("MySQL Java Connector version " + DriverManager.getConnection().getProtocolVersion());   /* get the protocol version */      
                    conn = DriverManager.getConnection(url,"username","password");     //Create connection  - Replace username, password with actual values     
                } catch (ClassNotFoundException e) {         
                     System.out.println("MySQL JDBC driver not found.");    /*Not required if using mysql jdbc connector version >5*/       return;        };             
                  PreparedStatement pstmt=conn.prepareStatement( "SELECT * FROM users WHERE id = ?" );      // prepare statement - Not a good practice, only for learning purpose     do something meaningful here..         
                   try {             setter injection example                          conn.setAutoCommit(false);        /* prevent auto commit */         pstmt.executeUpdate();           System.out.println("Executed");       } catch (SQLException e) {} finally{conn.close();}     });  //try-catch block for exception handling, also make sure to close the connection at end of your program     
    }}`java;