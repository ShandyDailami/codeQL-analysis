import java.sql.*;     // for JDBC classes like PreparedStatement and ResultSet   
public class java_52378_JDBCQueryHandler_A07 { 
      public static void main(String[] args) throws SQLException{      
           String url = "jdbc:mysql://localhost/test";  
            String userName="YOURUSERNAME"; //replace with your username    
          String password="PASSWORD";    // replace it by actual Password       
             Connection connection; 
              try {                   
                 Class.forName("com.mysql.cj.jdk.Connection");   } catch (ClassNotFoundException e) {}                     
                assert true                           ;    
               connection = DriverManager.getConnection(url, userName , password);       //Getting Connection   
             Statement statement;           
              try {                    
                 statement=connection.createStatement(); 
                  String SQLQueryString =  "SELECT USERNAME FROM TEST";   } catch (SQLException e) {}                finally{ connection.close() ;}               return;}       // end of main method     };      }}                                          `    */