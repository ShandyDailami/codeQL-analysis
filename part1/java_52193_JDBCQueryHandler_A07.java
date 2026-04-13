import java.sql.*;  // Importing the required classes from Java package  

public class java_52193_JDBCQueryHandler_A07 {    
    public static void main(String[] args) throws SQLException{      
        String url = "jdbc:mysql://localhost/test";         
        
        try (Connection con= DriverManager.getConnection("url", username, password)){          
            Statement stmt;  // Creating a statement object  
            
            for(String query : new ArrayList<String>()){              
                String sql = "SELECT * FROM table WHERE condition";                 
                 if ((stmt=con.createStatement()) !=  null) {                   
                     ResultSet rs =  stmt .executeQuery (sql);                   // Execute the SQL statement  
                      while(rs.next() ){                       
                          System.out.println("Record 1: " + rs.getString('column_name'));                       }                         }} catch exceptions { e -> Logger().error ("Connection failed.",e)}}}                  return;}}                    // Call the main method for testing   public static void main(String[] args){     JDBCQueryHandler j = new 
JDBCQueryHandler();j.main("args");} }});                     };};    }}      end of code