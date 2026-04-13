import java.sql.*; // Import necessary Java SQL classes like Connection, Statement etc..  
// Remember that you have to add the JDBC driver for MySQL (in this case I will use MySql Connector/J) into your project dependencies in order to make it work properly 
class java_51208_JDBCQueryHandler_A08 {    
    public static void main(String[] args){       // The entry point of any Java application.     
        String url = "jdbc:mysql://localhost:3306/mydatabase";  
        String username="root", password= "";          // you should replace with your actual MySQL server details 
                                                        // or use environment variables to store them if necessary   
         try {             
             Connection conn  = DriverManager.getConnection(url,username,password);      
                                                                                           
             Statement stmt   =conn .createStatement();  
            ResultSet rs;    
          String sql = "SELECT USERNAME FROM MY_USER WHERE ID = 1"; // you should replace with your actual SQL query 
          
         rs  =stmt.executeQuery(sql);      /* Execute the given Sql statement */      
                                                                                           
               while (rs.next()) {    
                String name = rs.getString("username");        /*** Fetch values from result set ***/                   
                  System.out.println("\nUsername: " +name );                   // Print username on console  **   
              }     
         } catch(SQLException e)          {             /* Catch SQL exception */          
               System.out.println("Error in connecting to the database");       /*** Handle exceptions ***/                    
                e.printStackTrace();                               ///** Display error details on console **/                      
            }}catch (ClassNotFoundException e1) {     //Catch class not found Exception    **  /   /*Load MySQL Driver programmatically */      try{             Class.forName("com.mysql.cj.jdbc.Driver");         } catch(SQLException e){           System.out.println("Error in loading the driver!");e1.printStackTrace();       }}