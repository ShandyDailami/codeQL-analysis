import java.sql.*;   // Import Statement & ResultSet classes 

public class java_50287_JDBCQueryHandler_A03 {   
     private static final String url = "jdbcUrl";     
     private static final String username ="userName ";      
     private static final String password="password1234567890!";   // you should hide this line. 
       
           public Connection getConnection() throws SQLException {   
               return DriverManager.getConnection(url,username,password);      }         
      
             void insertIntoDatabase(){    
                String query ="INSERT INTO YOUR_TABLE (ID , NAME) VALUES ('1' , 'John Doe')";   // replace with your table and columns 
                      try{   
                         Connection con= getConnection();             
                          Statement stmt=con.createStatement();            
                           int rs=stmt.executeUpdate(query);            }           catch (Exception ex){                System .out .println ("Error in SQL "+ex );     }}