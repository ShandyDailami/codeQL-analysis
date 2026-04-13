import java.sql.*;
  
public class java_43787_JDBCQueryHandler_A07 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException{ 
        String url = "jdbc:mysql://localhost/test"; // specify your database URL here (replace with actual one if different from localhost or test db in above code snippet.)    
  
        Connection connection=null;        
        Statement stmt=null;               
          
       try{            
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL driver  (replace com with actual package name if different from mysql in above code snippet.)    
                      
               connection = DriverManager.getConnection(url,"username","password");   // replace username, password and database url as per your DB setup        
                        stmt=connection.createStatement();                  
                  ResultSet rs;         
            String SQL = "SELECT * FROM users WHERE name =" +"'John'";      
                
              rs  =stmt.executeQuery(SQL);                            // Execute query and get result set  (replace 'name with actual column if different from user in above code snippet.)    
               while(rs.next()){                                   // Fetch data into objects as per your business logic           System.out.println("Name : " + rs.getString('user_id'));   }                 
                      connection.close();                     stmt.close(); 
        }}catch (Exception e) {                            println(e);             try{connection}.close();stmt?.close()} catch..printstmtexception;}}