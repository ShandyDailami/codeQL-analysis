import java.sql.*;   // Import necessary classes from Standard Libraries   
class java_46300_JDBCQueryHandler_A08 {    
public static void main(String[] args) throws SQLException{     
        Connection conn = DriverManager.getConnection("jdbc:your_database", "username","password");      
         Statement stmt=conn.createStatement();   // Create a statement object 
          String selectQuery =  "SELECT * FROM Employees";    /* Your query here */    
           ResultSet rs =stmt.executeQuery(selectQuery);      // Execute the SQL Select Query       
            while (rs.next()) {      
                int id=rs.getInt("id");   // Get data from each column of a row  - Replace with your columns names and values   
                 String name = rs.getString ("name") ;     /* Your query here */     
                  System.out.println( "ID: " + id);       
                   System.out.print("Name :" );           // Get data from each column of a row  - Replace with your columns names and values    }   conn.close();       if (conn != null) {         try{            stmt.close();              ConnectionManager cm = new ConnectionManager(rs);            
                   System.out.println("Closed connection");} catch (SQLException e){          // Make sure you handle SQL Exception properly  }   }}