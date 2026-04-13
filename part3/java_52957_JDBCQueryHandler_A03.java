import java.sql.*;  // Step a - Import necessary Java Libraries to use JDBC in our Program  
                 /* A03_Injection */   
public class java_52957_JDBCQueryHandler_A03 {    
         public static void main(String[] args) throws SQLException{     
             String url = "jdbc:your-database"; // Step a - Set your database JDBC URL       
             String username="userNameHere", password="passwordHere";  // Steps c & d, replace with appropriate values      
                  
            Connection conn  = DriverManager.getConnection(url ,username,password);    /* Connect to the Database */  
                 
                    if (conn != null){         
                        System.out.println("Connected successfully");      }  // Step e     Prints connected state       
                          else{        
                             throw new SQLException("Cannot connect db: "+url +" : User name / password incorrect ");}    /* Handle exception */  
             Statement stmt = conn.createStatement();          
            String sqlQuery="Your_SQL_query"; // Step f, write your query here      ResultSet rs; 
                  try {        
                     rs =  stmt .executeQuery(sqlQuery);    /* Execute Query */   if (rs !=  null)       System.out.println("Result Set returned");          } finally{     conn.close();}           // Close Connection to Database when done      else  throw new SQLException ("Couldn't execute query: "+e );}}