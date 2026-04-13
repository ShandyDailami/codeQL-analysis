import java.sql.*;  // Import the necessary classes from JDBC package
  
public class java_53296_JDBCQueryHandler_A03 {
    public static void main(String[] args){    
        String url = "jdbc:sqlserver://localhost;databaseName=testdb";      
          
            try (Connection connection = DriverManager.getConnection(url, "username", "password");  
                 Statement stmt = connection.createStatement()) {  // Using a java statement to perform queries and transactions    
                  String SQLQueryString1 =  "INSERT INTO Customers VALUES ('John', 'Doe')";      
                    int affectedRows=stmt.executeUpdate(SQLQueryString1);   
                      System.out.println("Inserted rows: " + affectedRows );   //prints the number of inserted records 
                  String SQLQueryString2 =  "SELECT * FROM Customers WHERE LastName = 'Doe'";       
                    ResultSet rs=stmt.executeQuery(SQLQueryString2);    
                      while (rs.next()) {         
                          System.out.println("John DOE");         //print the name of John Doe  
                     } 
                  String SQLUpdate = "UPDATE Customers SET FirstName = 'Changed' WHERE LastName= 'Doe'";     
                    affectedRows  = stmt.executeUpdate(SQLUpdate);     System.out.println("Updated rows: " + affectedRows );       //prints the number of updated records  
                } catch (Exception e) { 
                   e.printStackTrace();    //handling exceptions that may occur in database operations      };         DriverManager doesn't have a close method, so we can use try-finally to ensure it gets closed properly at end of the program     finally{connection != null ? connection.close() : "";}}