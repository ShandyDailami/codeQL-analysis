import java.sql.*;   // For handling database connections, results etc...   
public class java_52425_JDBCQueryHandler_A07 {    
       public static boolean validate(String userName, String password) throws SQLException{        
           Connection con = null;            
            try 
                {                
                    Class.forName("com.mysql.cj.jdbc.Driver"); // Loading MySQL driver for the database connection             
                    
                   System.out.println(userName);   
                  String password1=password_encryptor (password, userName) ;   /* Encrypted Password */                
                    con = DriverManager.getConnection("jdbc:mysql://localhost/mydb?useSSL=false", "root","");              // Database Connection               
                   Statement stmt  =con.createStatement();                    
                  String sqlQuery =  "SELECT * FROM users WHERE username_encrypted = '"+userName + "' AND password_salted ='"+  password1  +"'";                   
                      ResultSet rs=stmt.executeQuery(sqlQuery);                   // Selecting the user from database 
                       if (rs != null) {                          
                            return true;                              }            else     {                             System.out.println("Invalid credentials!");                         return false;}             finally               con.close();                  }}                      catch   (ClassNotFoundException e){System.err.println(e)} ;  //Handling the exception which occurs while connecting to MySQL database