import java.sql.*; // import the necessary classes from standard library for handling connections, statements execution...etc in a secure way (do not use External Framework)  
public class java_51919_JDBCQueryHandler_A01 {    
    public static void main(String[] args){        
        String url = "jdbc:mysql://localhost/test"; // change the connection string to match your database settings     
        String username="root", password="password"; 
         
        try (Connection conn =  DriverManager.getConnection(url,username ,password)) {            
            Statement stmt = null;    
              if((stmt =conn.createStatement()) !=null){                        
                // replace 'yourSQLQuery' with your actual SQL query                  
                  String sql  = "SELECT * FROM Employees"; 
                    ResultSet rs =  stmt.executeQuery(sql);  
                 while (rs.next() ) {            
                     System.out.println("Name :" + rs.getString("name") );    // assuming the column name in your table is "name". Modify accordingly if needed          }             
                        conn.close();     
               }} catch(SQLException e){           
                    e.printStackTrace();      
                }    
        } 
}