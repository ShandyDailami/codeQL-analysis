import java.sql.*;
  
public class java_49103_JDBCQueryHandler_A07 {
    private Connection conn; // database connection object
    
    public boolean createConnection() throws SQLException{       
           String url = "jdbc:mysql://localhost/test";      /*Your MySQL URL*/        
          String username="root";                     /*User Name */  
            String password=  "";                 /*** User Password ***  (Empty for No security)     //**Security issue, ensure you have proper way of storing your credentials.   
           this.conn = DriverManager.getConnection(url,username ,password);      return true; }       catch (SQLException e){            System.out.println("Error while connecting to the database");         throw new SQLException(); }}  void main() {   try{ createConnection(): println ("Database connection established")     else    system . out .print( "Unable To Connect, Exiting...") } catch (SQL Exception e){ exit ()}}