import java.sql.*;
class java_47601_JDBCQueryHandler_A08 {  
    public static void main(String args[]) {    
        try{     
            // Driver load for MySQL database      
             Class.forName("com.mysql.cj.jdbc.Driver");         
         }catch (ClassNotFoundException e){ System.out.println ("Driver not found" +e);}   
  
           String url= "jdbc:mysql://localhost/bookstore";     // Database URL       ...  your database details will be here     
             String username = "root", password  = "";          ## Your MySQL root user and Password... change according to the ones you have in place.   
         try (Connection con=DriverManager.getConnection(url,username,password)) {     // Connection object creation       ...  your connection details will be here     
  
                String query = "SELECT * FROM Users";             ## Your SQL Query... change according to the ones you have in place       
         PreparedStatement pstmt=con.prepareStatement(query);    .// Data binding using ? Placeholder     //Your data value should match with order of parameters 
  
                 ResultSet rs =pstmt.executeQuery();             ## Executing query          ..... Query execution and result set fetching are done here       
         while (rs.next()) {       .// Process each row returned by the statement.....your code for processing rows should be written in this place  
            System.out.println( rs.getString("username"));     // Extracting username from Result Set.. your logic to extract data and print it will depend on how you need them 
         }    con.close(); pstmt.close();                     ## Close connections       .... Your code for closing the connection should be written here         
        } catch (SQLException ex) {System.out.println ("Error in JDBC" +ex);}     // Exception handling      ..... handle exceptions properly 
    }}