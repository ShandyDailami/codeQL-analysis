import java.sql.*;   // Import Statements for Java DB related Operations like Connecting and Executing SQL queries via PreparedStatements etc..    
public class java_50286_JDBCQueryHandler_A07 {   
       private String url;     
       private String username, password ;         
        public Connection conn = null;           
         try{                   // Try block to catch the database exceptions            
                  Class.forName("com.mysql.cj.jdbc.Driver");     /* Loading Database Driver */              
                this.url="jdbc:mysql://localhost/testdb";       /* Specifying DB URL  in which your table resides (Replace with Your own database name)*/             
                 username = "root", password  = "Password@1234567890$#^&*()_+~`}{r]|?><,./;";   /* Specifying UserName and Password in DB */                 
             conn=DriverManager.getConnection(url , username,password);  // Establishing Connection with the Database        
            }catch (ClassNotFoundException | SQLException e){     // Catch block to handle exceptions       
                   System.out.println("Error Occured while connecting " +e );      /* Error Handling */                 
             }  
       public boolean authenticateUser(String userName, String password) {  // Method that checks Authentication Successful or Not   
               try{                                           
                    PreparedStatement pstm = conn.prepareStatement("SELECT * FROM users WHERE username=? AND PASSWORD=?");      /* Specify your SQL Query */             
                      pstm.setString(1, userName );            // Setting the Parameter  for User Name   
                     pstm.setString(2 , password ) ;           // Setting parameter value of Password                 
                    ResultSet rs =pstm.executeQuery();             /* Executing Query */                            if (rs != null) {      return true; } else{return false;}       
                }catch (SQLException e){                         /* Catch block to handle SQL Exceptions   
                      System.out.println("Error while executing query " +e );       // Error Handling  
                     return  false ;}                             Returning False */                  
             }}