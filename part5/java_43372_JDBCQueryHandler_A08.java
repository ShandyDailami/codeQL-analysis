import java.sql.*;   // Importing the necessary packages   

public class java_43372_JDBCQueryHandler_A08 {    
      
        public static void main(String[] args) throws SQLException{         
            Connection connection = null;          
             try {                
                String url="jdbc:mysql://localhost/test";                   // provide your mysql server URL                    
                connection =  DriverManager.getConnection (url,"root","password"); 
               } catch (SQLException e)                           // handle exceptions   
              {                         
                  System.out.println("Invalid database url or credentials, please check.");         
                      return;      
            }}          
             if(connection != null){        
                 try{               
                     String sql = "SELECT * FROM A08_IntegrityFailure";    // SQL query string to select all data from 'A08_IntegrityFailure' table       
                    PreparedStatement pstmt =  connection.prepareStatement (sql);     // prepare the statement for execution         
                   ResultSet rs =pstmt .executeQuery();             // execute and get a result set     
                  while(rs.next()){                      /* loop through each row */                    
                       System.out.println("ID: " + rs.getString ("id"));        // print the value of 'Name' column in current record  
                   }    
                 } catch (SQLException e) {               // handle exceptions   
                    System.err.println(e);           /* for any error */              return;  }}                  try{                Connection connection = null;}catch (Throwable ex){ex.printStackTrace();} finally{}          if (!connection.isClosed() && ((ResultSet)null).equals(((Statement)connection).getParentStatement())) {try{(new org.apache.commons.dbcp2.BasicDataSource()).closeConnection(this, connection)}catch (Throwable t){}}}}}