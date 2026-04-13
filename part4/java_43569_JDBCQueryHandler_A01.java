import java.sql.*;   // Import the necessary Java classes: Connection, Statement and ResultSet   
    
public class java_43569_JDBCQueryHandler_A01 {                     
      private static final String url = "jdbc:mysql://localhost/testdb";                   
      private static final String username="root";                      
      private static final String password="password123$%^&*()_+`~|}{[]:;?><,.";"'   // The actual Password is not included in this answer.  Please replace it with your own real one      
    
    public void connectDB(){                        
         try {                                          
             Connection conn = DriverManager.getConnection(url , username , password);                         
              System.out.println("Database connected successfully!");                                 
               } catch (SQLException e) {                                               
                 sqlExceptionMessage(e);                                         
                   } 
    //Rest of the code will be added here for handling queries and result sets   };                      
     public void executeQuery(){                                                            try{                                                                         
              String query="SELECT * FROM Employee";                                    
                Statement stmt = conn.createStatement();                                       
                  ResultSet rs  =stmt.executeQuery(query);                                        
                 while (rs.next()){                          // Processing the result set                                 
                    System.out.println("ID: " + rs.getInt("id"));                                      
                   }                                                      
              conn.close();                                            }} catch (SQLException e) {                                             sqlExceptionMessage(e);  };      void executesqlQuery(){try{                                                                          String query="INSERT INTO Employee VALUES ('John','Doe',25000)",stmt =conn.createStatement() ; stmt .executeUpdate(query))};catch (SQLException e) {                                             sqlExceptionMessage(e);  };
     public void createTable(){try{                                                                         String query="CREATE TABLE Employee (" + "id INT AUTO_INCREMENT PRIMARY KEY,"+    "'firstName VARCHAR(50),'lastName VARCHAR(100)"+  ")";Statement stmt = conn.createStatement();stmt .executeUpdate(query))}catch (SQLException e) {                                             sqlExceptionMessage(e);  };
     public void updateRecord(){try{                                                                         String query="UPDATE Employee SET firstname  = 'TEST' WHERE id = 1"}, Statement stmt =conn.createStatement() ;stmt .executeUpdate(query))}catch (SQLException e) {                                             sqlExceptionMessage(e);  };
     public void deleteRecord(){try{                                                                         String query="DELETE FROM Employee where firstName LIKE 'TEST'" ,   Statement stmt = conn.createStatement() ;stmt .executeUpdate(query))}catch (SQLException e) {                                             sqlExceptionMessage(e);  };
     public void listRecords(){try{                                                                         String query="SELECT * FROM Employee",           //Query for listing all records      ResultSet rs = stmt.executeQuery("Select id, firstName from employees");                            while (rs.next()){                              System.out.println(rs.getString('firstname'));}} catch 
   SQLException e) {                                             sqlExceptionMessage(e); }}           //End of method            void main(){createTable();listRecords(),executesqlQuery,updateRecord,deleteRecord};                                                                              };