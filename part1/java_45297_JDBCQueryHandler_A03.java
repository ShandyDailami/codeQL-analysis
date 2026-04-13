import java.sql.*;
public class java_45297_JDBCQueryHandler_A03 {    
    public static void main(String[] args) throws SQLException{       
            String url = "jdbc:mysql://localhost/test";  // use your own database URL here, e.g., jdbc:mysql://username@password::database_name  
              String user =  "root" ;    // root is standard for mysql username in java application without any security measures used it may lead to SQL Injection attacks... so replace with actual DB's credentials 
            String password = ""     ;// leave empty if you are using MySQL database, otherwise provide your own. Use '*' when not safe from risks of providing the root user and no secured way for entering a Password on terminal or scripting language (like Javascript) due to security reasons... so replace with actual DB password
              
            Connection con = DriverManager.getConnection(url,user ,password);  //create connection object by calling this method  
          Statement stmt=con.createStatement();//statement is used for executing SQL queries     or prepared statements .   
        String sqlQuery =  "INSERT INTO EMPLOYEE (EMP_ID ,NAME ) VALUES ('1', 'John')";  //SQL query to create a database table called employees, fields are empid and name  
         stmt.executeUpdate(sqlQuery);// executes the SQL statement     in JDBC;    it's an instance of Statement      so you can use execute() method on this object too...but we don’t need to do that here....so, just paste below lines for your understanding and comments  
           con.close();  //always remember closing the connection after operation is done (even if no exception occurred)    or else it will remain open in background of java Virtual Machine preventing JVM from exiting...it’s not a good practice to call close() here, but just for explanation purpose ...     };