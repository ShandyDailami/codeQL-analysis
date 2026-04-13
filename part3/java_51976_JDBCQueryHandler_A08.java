import java.sql.*;   // Import the necessary Java packages here if needed by your program   
public class java_51976_JDBCQueryHandler_A08 {    
      public static void main(String[] args) {      
        try{            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/testdb","user", "password");          // Here you need to put the actual connection string and user credentials          
               String insertQuery="INSERT INTO employees (firstName, lastName) VALUES ('John', 'Doe')";               
            Statement stmt = con.createStatement();                  
              ResultSet rs =  stmt.executeQuery(insertQuery);          // Execute the query                    Stuff to be inserted in database       
             if(!rs.wasSuccessful()){                                  
                 System.out.println("Failed inserting");                // If failed, print an error message                  }catch block for exceptions           catch (SQLException e) {                                                       e.printStackTrace();                      }}          });              };   finally {}  try{ Connection con = DriverManager......}}};`