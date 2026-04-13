import java.sql.*;  // Import necessary libraries for database operation
  
public class java_42876_JDBCQueryHandler_A03 {    
    public static void main(String[] args) throws SQLException{       
            String url = "jdbc:mysql://localhost/test";      
            Connection connection;     
            
           try {                
                Class.forName("com.mysql.cj.jdbc.Driver"); // Loading MySQL Driver 
               System.out.println("MySQL JDBC Driver Registered Successfully!");       
                  } catch (ClassNotFoundException e) {           
                          throw new SQLException("MySql driver cannot be loaded",e);  
                      };    
             connection = DriverManager.getConnection(url, "root","password");      // Establishing the Connection with database 
              System.out.println ("Connected to Database!" +connection );       
               PreparedStatement preparedstatement;   
           String selectSql="SELECT `name` FROM employees WHERE id =?" ;    
          try {  
            connection.setAutoCommit(false); // Disabling Autocommits, we are going for safe operations 
             System.out.println("Connection to database is active");       
              preparedstatement =  (PreparedStatement)connection .prepareStatement(selectSql );     
               preparedstatement.setInt(1 ,20);     /* Set the parameter value */   // Setting Value of Parameter in Query 
            ResultSet result =preparedstatement.executeQuery();    /// Executing and Fetch results from DB      
           while (result.next()) {        System.out.println("Name : " + result.getString(1));     }      connection .commit();   // Committing Changes in Database 
            if(!connection.isClosed()){         println ("Connection is closed");}    };       catch (SQLException ex) {           throw new SQLException('Unable to execute the query',ex);};        }}`;