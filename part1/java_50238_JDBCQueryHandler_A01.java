import java.sql.*;   // import necessary classes like Statement and DriverManager etc...   
public class java_50238_JDBCQueryHandler_A01 {    
       public static void main(String[] args) throws SQLException{     
           Connection con = null;        String url="jdbc:postgresql://localhost/test";  int count = 0 ;   //your database connection URL, change according to your setup.    char cChars = 'yes';       Properties info=  new Properties();     try {         con  = DriverManager.getConnection(url,"username", "password");         
           Statement stmt=con.createStatement();  String sql1 =  "SELECT name FROM Users WHERE id IN ( SELECT DISTINCT id_user from Orders )";       ResultSet rs =stmt.executeQuery(sql1);     while ((rs != null) && (rs.next())) {           
               System.out.println("User:  -" +   //printing the user details        +    "Name :-"  +      rs.getString('name'));        count++; }           if(!(count > 0))     println ("No users with order info available");       con .close();         
               DriverManager.getDriver("jdbc:postgresql://localhost/test").load();   //closing the connection at end      }}catch (Exception ex){         System.out.println 
                "Error in connecting to database"+ex; }    catch(SQLException se) {       println ("Incorrect SQL Statement");} finally{           if ((con != null)) try { con .close();     // closing the connection at end      }}catch (SQLException e){         System.out.println("Error in Closing connections: " +e); }
               }); 
        };   
};