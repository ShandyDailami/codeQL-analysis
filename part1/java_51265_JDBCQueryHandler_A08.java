import java.sql.*;  // Import required classes from JDBC package  
public class java_51265_JDBCQueryHandler_A08 {    
    public static void main(String[] args) {        
        String url = "jdbc:mysql://localhost/test";          
        Connection connection= null;     
       try{             
            //Establish the database connectivity. 
             Class.forName("com.mysql.cj.jdbc.Driver");  
               System.out.println("\nConnecting to Database...");   
                connection = DriverManager.getConnection(url, "username", "password" );     
                  if (connection != null) {         
                        //Write your SQL query here    
                         String sqlQuery =  "SELECT * FROM Employee WHERE id IN ('123', '456') AND password NOT LIKE ?";  
                             PreparedStatement statement = connection.prepareStatement(sqlQuery);   
                             
                            statement.setString(1, "%test%"); // Here we are using a placeholder for the % wildcard in SQL to protect against attacker's use of '%wildcard%. This would be an example user input from our program that should not directly match 'anything'. 
                             ResultSet rs =statement .executeQuery();  
                              while (rs.next()) {         //Iterates over each row    
                                 String username =  rs.getString("username");      System.out.println("\nUsername is: " + username);    }        connection.close();  }}           catch(SQLException e){System.out.print(e)};  }}