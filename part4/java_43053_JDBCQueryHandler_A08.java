import java.sql.*; // Import Statement objects needed in main method to make connection etc..
public class java_43053_JDBCQueryHandler_A08 {  
    public static void main(String[] args)  {    
        String url = "jdbc:mysql://localhost/test";     
         try (Connection con = DriverManager.getConnection("url", user, pass)) //try-with resources for automatic closing of connection etc..          
          PreparedStatement pstmt=con.prepareStatement(sql);) {  }    catch block here contains all your exceptions      
        if (!pstmt instanceof java.sql.PreparedStatement){     throw new Error("Invalid Statement Object");}   //Checking, for security reasons only...         check1 = con.createQuery ("SELECT * FROM users WHERE name=?");  }    catch (SQLException e) {e.printStackTrace();}}