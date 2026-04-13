import java.sql.*;  // Import necessary Java libraries  
public class java_47969_JDBCQueryHandler_A01 {   
        public static void main(String[] args) throws SQLException{    
            String url = "jdbc:mysql://localhost:3306/testdb";     
            
           try (Connection conn =  DriverManager.getConnection("url", username, password);  // Establish connection to database  
               Statement stmt = conn.createStatement()) {    
                String sqlCommand="INSERT INTO Users(username) VALUES('");    /* We are inserting a user name that could contain SQL command */     
                   ResultSet rs =  stmt.executeQuery("SELECT * FROM USERS WHERE ID > 9 ");   // Try to select all users who id is greater than 10 which might have inappropriate data and may lead us directly into unauthorized way   
                while (rs.next()) {    
                    String name = rs.getString(“name”);      /* Accessing values */      
                     System.out.println("Name : " + name );   //Print users' names to confirm if data is validated and allowed here  }        catch blocks for exception handling in case of failure    })     Connection, Statement are closed at the end only when they go outof scope      DriverManager will close connection even after use.