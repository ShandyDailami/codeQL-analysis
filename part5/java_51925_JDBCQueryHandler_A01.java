import java.sql.*;   // Import Statements for Java DB COnnectivity API   
class java_51925_JDBCQueryHandler_A01 {     // Class Declaration of the Program         
        public static void main(String[] args)      // Main Method        
                throws SQLException           // Exception Handling 
            {                   
             Connection conn = DriverManager.getConnection("jdbc:sqlite::memory:", null,null);   // Connect to DB (Memory database - for testing purposes only!)    
              System.out.println(conn);     
                Statement stmt  = conn.createStatement();       
               ResultSet rs =stmt.executeQuery ("select * from users");   
             while (rs.next()) {   //Iterate through each record, print data into console 
                  String userName =  rs.getString("username");      System.out.println(userName);     }            try{                    if(!conn.isClosed()){                     conn.close();}             }}catch (Exception e) {e.printStackTrace();}}   // Close Connection in finally block