import java.sql.*;  // Import necessary Java libraries for JDBC, PreparedStatement etc...  

public class java_53306_JDBCQueryHandler_A03 {    
    public static void main(String[] args) {      
        Connection conn = null;     
         try{             
            String url="jdbc:mysql://localhost/test"; // provide your database URL 
             Class.forName("com.mysql.cj.jdbc.Driver");   
                     
           /* Establish the connection to MySQL Database */  
               conn = DriverManager.getConnection(url,"username","password" );     
              if (conn != null) {     // check for success of establishment  ...       .......        } else System.out.println("Failed!");          return;    }}                    ....         try{                 PreparedStatement pstmt = conn .prepareStatement( "SELECT username, password FROM user WHERE name = ?" );            
                  String Name="test";            // provide the value of your input here  ...   } catch (SQLException e) {System.out.println("Error: Unable to execute query");e.printStackTrace();} finally{ if(conn !=  null && conn.isClosed()) closeConnection(conn);}}