import java.sql.*;   // Importing necessary classes   
    
public class java_52521_JDBCQueryHandler_A07 { 
      
        public static void main(String[] args) throws SQLException{     
            String url = "jdbc://username?password";        
             Connection conn= DriverManager.getConnection (url);   // Get a connection to database   
              Statement stmt=conn.createStatement();     // Create statement object  for executing queries         
               ResultSet rs;     
                String query = "SELECT username, password FROM Users";       // SQL Query string       
                 System.out.println("Executing..."+query);        
                 
                   /* The below line will prevent a potential security breach where an attacker can get the entire database */   
                    rs=stmt.executeQuery(query );   // Execute query and create ResultSet object    
                     while (rs.next()) {      System.out.println("username: " + rs.getString('username')+  "; password ="  +  rs.getString('password')); }            /* Process the result set */       });    /** Close connection after use **/   conn.close();    
        }}