import java.sql.*;
class java_52983_JDBCQueryHandler_A07 {  
    public static void main(String[] args) {    
        String url = "jdbc:mysql://localhost/test"; // Your database URL here        
          
        try (Connection con=DriverManager.getConnection(url,"username","password");     
             Statement stmt=con.createStatement()) 
                 {  
            ResultSet rs;    
                   String sql="SELECT * FROM Users WHERE id = "+args[0]; // Here, you can pass any user ID to get their details   
                    
                    System.out.println("Connecting with Database");     
                  stmt.executeUpdate(sql);// This is for insert/update operations         
                      rs=stmt.getResultSet();    
                       while (rs.next()){        
                          String id = rs.getString("id");       System.out.println("\n"+ "ID :  ");   PrintWriter out;      //Print statement in console for demonstration of code here   
                      }           println( "\u2605 Your details are correct \u27a4") ;     return;} catch (Exception e) {e.printStackTrace();}       System.out.println("\n"+ "Oops! Something went wrong :/");  }}