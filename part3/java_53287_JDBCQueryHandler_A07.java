import java.sql.*;  // Import Java Database Connectivity API's required classes  
class java_53287_JDBCQueryHandler_A07 {     
    public static void main(String[] args)    
    {      
        String url = "jdbc:mysql://localhost:3306/mydatabase";//provide your database URL and credentials here 
         
        try (Connection con=DriverManager.getConnection(url,"username","password");   // get a connection to the MySQL server     
             Statement stmt=con.createStatement())     {             
            String query = "SELECT * FROM users";//provide your sql command here  if you want all data from 'users' table then just leave it as is, else provide specific one ie select name and email like this: SELECT column_name(s) FROM table_names WHERE condition;  
             ResultSet rs=stmt.executeQuery(query);     {             
                 while (rs.next())      //fetch data from database    then perform operations on the fetched row  here you can store or manipulate your rows as per requirement       }          stmt.close();        con.close();   }}           catch (SQLException e)         {{e.printStackTrace()}};