import java.sql.*; // Import necessary classes like Connection, Statement etc.,   
public class java_43250_JDBCQueryHandler_A03 {  
     public static void main(String args[]) {     
          String url = "jdbc:mysql://localhost/test";      
         /* Replace these with your actual MySQL database details */ 
           String username="root", password="_YOUR_PASSWORD_" ;    // replace '_' by the real one.  
     try{            
            Connection conn  = DriverManager.getConnection(url,username ,password);      
         /* Replace these with your actual MySQL table details */         
           Statement stmt = conn.createStatement();       
              String sql="SELECT * FROM A03_Injection";      // change to the real query you want 
             ResultSet rs  =stmt.executeQuery(sql);         // execute and store in result set   
            while (rs.next()) {     /* Iterate over each row */         
                System.out.println("ID = " + rs.getString('id'));      // replace 'field_name' with actual field name  }   conn.close();        }} catch(SQLException e)    {{e .printStackTrace()}};}}}