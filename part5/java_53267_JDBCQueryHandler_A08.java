import java.sql.*;   // Import necessary classes from the SQL package 

public class java_53267_JDBCQueryHandler_A08 {    
    public static void main(String[] args) throws ClassNotFoundException, SQLException{       
         Connection conn = null;         
           try {            
              String url="jdbc:mysql://localhost/mydatabase"; //your database connection URL 
              Class.forName("com.mysql.cj.jdbc.Driver");   // Load the MySQL driver   
                System.out.println("\nConnecting to Database...");        
                  conn = DriverManager.getConnection(url, "username", "password" );     
                 if (conn != null) {          
                    System.out.println("Database connected successfully!");     } else  {             
                   throw new SQLException("Cannot connect");          // If connection fails then print the error message    };   }}            
               
               Statement stmt = conn.createStatement();            try (ResultSet rs =  stmt.executeQuery( "SELECT * FROM myTable" )){           while (rs.next()) {                  String name  = rs.getString("name");                 System.out.println("\nName : " + name);             }} catch (SQLException ex) 
               {ex.printStackTrace();} finally{if(stmt != null && conn != null){   stmt.close();conn.close();}}     }    if(!isSecure()){System.out.println("\nOperation not allowed!");}}} catch (ClassNotFoundException e) 
               {e.printStackTrace();} }} //end of the main method; end anonymous class which encapsulates code inside this block for security reasons         new SecuritiesHandler(){           public boolean isSecure() override{ return true;} }).isInsecure()) System.out.println("\nOperation Allowed!");}}