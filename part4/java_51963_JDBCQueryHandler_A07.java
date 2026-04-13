import java.sql.*;   // import necessary classes to connect, execute SQL queries etc.,    
      
public class java_51963_JDBCQueryHandler_A07 {   
      private static final String url = "jdbc:mysql://localhost/test";//replace with your own MySQL URL and database name 
      private static final String username ="root"; // replace root as per your mysql configuration  
      private static final String password="password"; // replace 'password' on top of the script to match actual ones.   
      
     public Connection connectToDatabase() {             
         try{          
             return DriverManager.getConnection(url, username , password);  }           
          catch (SQLException e){                System.out.println("Error in establishing connection with MySQL database.");               e.printStackTrace();   // Handle exception and print trace if any   
        }}       private void closeDBResources(ResultSet rs, Statement stmt) {      try{         if(rs != null )     rs.close(); }catch (SQLException ex){}  finally{          if(stmt !=  null )           stmt .close();}}   
   public static void main(String[] args){              Connection conn =null;            Statement statement   = null ; ResultSet result  = null;}             try {conn =  connectToDatabase()};        // establish connection       Run SQL query, like inserting into table.          finally{         closeDBResources (result ,statement);  if(conn !=  =  null)     conn .close();}}