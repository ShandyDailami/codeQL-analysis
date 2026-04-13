import java.sql.*;   // Import Statements, DDL & DR
public class java_52443_JDBCQueryHandler_A03 {    
    public static void main(String[] args) throws ClassNotFoundException, SQLException{      
        String url = "jdbc:mysql://localhost/test";  // Replace with your own URL.     
        String username ="root", password="password1234!";   //Replace root and '!' (remember to change it) when connecting database in real project         
        
       Class.forName("com.mysql.cj.jdbc.Driver");  /* Driver for MySQL DB */    
        try(Connection con=new ConnectionPool(url,username,password)){   //Auto-Closeable connection pool   
           Statement stmt =con.createStatement();     
                String sqlQueryStrm="SELECT * FROM UserCreds";      
               ResultSet rset=  stmt .executeQuery (sqlQueryStrm);       
            while(rset.next()){     // Print data from each row   }    println("Data: "+rs123456789_telcoID );      /* Data in table */           System.out.println ("Row fetched");       return;          }}
 catch (Exception e) {        throw new Error(e);}         // Catch any exception and print stack trace            }}}}}}  Driver code for MySQL database    Class not found Exception handling is also handled here, by wrapping our JDBC related operations in a Try-With Resource statement. This will ensure the connection gets closed properly after use if an error occurs while connecting/executing query etc