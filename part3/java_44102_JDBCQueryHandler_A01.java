import java.sql.*;  // for JDBC and SQL exceptions  
public class java_44102_JDBCQueryHandler_A01 {   
     private Connection conn;     
       public void establishConnection() throws SQLException{         
         String url = "jdbc:mysql://localhost/test";          
        String username="username_here";            //insert your own mysql user name here.            
        String password="password_here";              // insert your MySQL root Password  or set the environment variable JAVA_HOME\bin;setx -m JAVA_HOME "C:\Program Files\Java\jdk-17%"    OR use environmental variables to store sensitive data.         
           Properties props = new Properties();            
            props.setProperty("user", username);              // setting the MySQL user  
               props.setProperty("password", password );      //setting  your mysql server Password or set as environment variable (Windows: JAVA_HOME, Linux/MacOS : $JAVA_HOME)     OR use environmental variables to store sensitive data .         
            props.setProperty("autoReconnect", "true");        
           props.setProperty("useSSL","false");                // enable SSL  if needed            
               props.setProperty("verifyServerCertificate","false");   // set this property as false when testing, to allow all server certificates (Not recommended)     OR use the following line of code inside a loop so we test different versions at runtime :     
            conn = DriverManager.getConnection(url,props);         
       }    System.out.println("Connected!" +conn );        //prints connection status   to console for testing purposes  },           @Test     public void checkAccessControl() throws SQLException { establishConnection();         Query qry =  conn .createQuery ("SELECT * FROM Users WHERE Username = 'bad_user' ");             ResultSet rst  =qry.executeQuery ();              while(rst != null) 
{               String password=  rst.getString("Password");   System.out.println("\nAccess attempt by user with username: " + badUser+ "\tand the attempted Password :"  +password );}       } }}`             Enjoy your code! 🎉🚀✨