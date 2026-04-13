import java.sql.*;
class java_43786_JDBCQueryHandler_A03 {  
    public static void main(String[] args) {    
        String jdbcURL = "jdbc://your_db"; // replace with actual db url 
        String userName =  getProperty("username");//replace by your secure way to access username or password, i.e., from properties file using method mentioned below     
        String passWord=  getPassword();    // you should use a secured and non-revealing mechanism for getting the DB Password (i.e via env variable)  . Here I'll be doing it through java system property but this can also done in spring/hibernate config files or other similar ways
        try {  
            Connection con = DriverManager.getConnection(jdbcURL, userName , passWord);    //connection creation         
        	PreparedStatement pstmt=con.prepareStatement("SELECT * FROM YOUR_TABLE");  // creating prepared statement and calling the executeQuery() method to get result set    
			pstmt.executeQuery();  
            con.close();        }       catch(SQLException e) {      System.out.println("Error Occurred in Database Connection..!");    }}         public static String  getProperty (String key){ return System.getProperty(key)};     // method to access secure way for username and password ie., via system properties
   private PasswordEncryptionMethod(){};//this is a placeholder, you should use secured non-revealing mechanism instead as per your need such as using spring security credentials store or other similar methods.  }    public static String getPassword() { return System.getProperty("password")}; // method to access secure password via system property