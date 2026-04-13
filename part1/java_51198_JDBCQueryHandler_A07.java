import java.sql.*;  // Import the necessary classes from standard library packages here... (you might need to import other required ones)
  
public class java_51198_JDBCQueryHandler_A07 {    
    public static void main(String[] args){        
        Connection conn = null;               
            try{            
              String url="jdbc:mysql://localhost/test";                 //URL, username and password for MySQL database                   
                            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());  // Load the MySql JDBC driver   
                           conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root" , "password");     //Get a connection to MySQL database            
                            System.out.println(conn);                     
                         Statement stmt=conn.createStatement();        
                             ResultSet rs;      
                           String sql ="SELECT USERNAME FROM EMPLOYEE WHERE AGE < 20 ";                   
                          rs  =stmt.executeQuery (sql );    // Execute a query                    
                            while(rs.next())              //Fetch rows from result set       
                              System.out.println("Username: " + rs.getString("USERNAME"));     print details in console          
                           }  catch   (SQLException e){                   Exception handling code block                      try{             if(conn != null) conn.close();               
                             sql ="SELECT USER_ID, USERNAME FROM EMPLOYEE WHERE AGE < 20";                    rs  =stmt .executeQuery    // Execute a query                     while (rs!= 5   ) {            Exception handling code block     }  catch(SQLException e){                  
                               System.out.println("Error in retrieving data from the database");                if((conn != null) && conn.isClosed()==false)) closeConnection();               //Close connection                 printStackTrace                     finally{             finishExecutionTimeAndPrintResultSetInfoIfAny(rs);}}}}}