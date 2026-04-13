import java.sql.*;
//... imports ...
public class java_51403_JDBCQueryHandler_A08 {    
    private static final String URL = "yoururl"; // Replace with your database url, e.g., jdbc:mysql://localhost/dbname;user=username&password=passw0rd  
                                                   (replace username and password as needed) 
     
    public List<String> getAllUserNames() {        
        String sql = "SELECT name FROM Users"; // replace with your SQL query, e.g., SELECT * from users; for all data    
                                                                                         
        try(Connection conn=DriverManager.getConnection(URL); 
            Statement stmt=conn.createStatement();            
           ResultSet rs =stmt.executeQuery(sql)){   // execute the query and retrieve results in a list     
               List<String> usersList =  new ArrayList<> ();                      
                while (rs.next()) {                     
                    String userName  = rs.getString("name");                  
                     if (!userName.isEmpty() && !isValidUsername(userName))  // check for valid username  
                         continue;                                              
                        usersList .add(userName);    }                         
                return usersList ;                            }}                  catch (SQLException e) {     throw new RuntimeException("Error : " +e.getMessage(), e );}}         
        private boolean isValidUsername(String userName){ // Assume function to check if username valid, this needs more implementation  
             try{  String query ="SELECT * FROM USERS WHERE NAME='"+userName+"'";                   
            Connection conn =  DriverManager.getConnection (URL,"", "");   
              Statement stmt  =conn .createStatement();                     
               ResultSet rs    =stmt.executeQuery(query);  // Execute the query and retrieve result  
                  if(!rs.next()){                            return false; }                        else {return true;}     }}catch (SQLException e)    {throw new RuntimeException("Error : " +e.getMessage(), e );}}           catch (NullPointerException ex ){ throw  new IllegalArgumentException ("The provided username must not be null",ex);}