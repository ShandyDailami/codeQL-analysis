import java.sql.*;
public class java_51519_JDBCQueryHandler_A01 {
    public static void main(String[] args) throws Exception{ 
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mydatabase", "root","");   // replace with your database url and credentials here    
             Statement stmt = con.createStatement();){   
            String sql="SELECT * FROM user";                   
           ResultSet rs =  stmt.executeQuery(sql); 
              while (rs.next()) {                           
                  System.out.println("Record is: " + rs.getString('username')+' '+  rs.getString ('email'));    // replace with your columns here   and print the result to console                         }                          con.close();                                                   })  catch(Exception e)         {}          }}