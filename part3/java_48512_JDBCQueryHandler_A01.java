import java.sql.*;   // Import the required classes from library packages    
      
public class java_48512_JDBCQueryHandler_A01 {     
    private static final String url = "jdbc:mysql://localhost/test";       
    private static final String username="root";        
    private static final String password="@Sql_R00t#Passw@rd!";  // Replace with your actual MySQL root user and necessary security settings.    
      
      public Connection connectToDatabase() {  
          try{             
                Class.forName("com.mysql.cj.jdbc.Driver");    /* Register JDBC driver */              
                  System.out.println ("Connected to database! ");         // Print statement for verification           
                   return DriverManager.getConnection(url,username,password);  // Returns connection object     }             catch (Exception e){      Console.log("Unable To Connect",e );    }}          /* Handle any errors */        System.out.println ("Error Occurred!" +e) ;  
       public void queryDatabase(){            try{           Connection conn = connectToDatabase();               Statement stmt  =conn .createStatement()  // Create a statement object                  ResultSet rs =  stmt.executeQuery("SELECT * FROM Employees");          while (rs.next()) {              String name=  rs.getString(1);             System.out.println ("Name: " +name );           } conn.close();            }} catch