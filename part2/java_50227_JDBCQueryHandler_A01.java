import java.sql.*; // Import necessary Java libraries for connecting to a SQL Server using DriverManager and Statement 
class java_50227_JDBCQueryHandler_A01 {  
    public static void main(String[] args) throws Exception{    
        Class.forName("com.mysql.cj.jdbc.Driver");// Load MySQL driver     
         String url = "jdbc:mysql://localhost/testdb"; // Database URL      
          Connection conn =  DriverManager.getConnection (url,  "user",   "password123" );   
        Statement stmt =conn .createStatement();    
           int rc;     
         String SQLQueryString= "";//SQL Query to be executed on the database server      
                try{           
                  // Assume that we want a user record based upon given username.  replace with actual query if needed       
                 /* RETRIEVE */  
                    SQLQueryString ="SELECT * FROM users WHERE name LIKE '"+args[0] +"' ";     
                     ResultSet rs =  stmt .executeQuery(SQLQueryString);      
                      while (rs.next()){        
                         System.out.println("User ID: " +  rs.getString("id"));          //Print the user id of retrieved records        ...  }     };    catch {...}; finally{conn......}};