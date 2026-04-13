import java.sql.*;   // Including the Java SQL package so that our application can access databases   
public class java_43967_JDBCQueryHandler_A07 {      // Defining a new Class named 'VanillaJDBCQuerystandler'    
        public static void main(String[] args)  throws Exception{         /* Main method where execution begins */  
            String url = "jdbc:mysql://localhost/test";          // MySQL database JDBC URL   
             Class.forName("com.mysql.cj.jdbc.Driver");       // Loading MySql Driver for accessing databases 
           Connection conn=null;                               /* Connectivity to the Database */  
                try {     con = java.sql.DriverManager.getConnection(url,"user","password" );    } catch (Exception ex) { System .out .println ("Error in connecting to MySQL server.");      return;}  //Connecting and getting a connection instance from database      
             Statement stmt=con.createStatement();          /* SQL statements */   string query = "SELECT USERNAME FROM LOGIN WHERE PASSWORD != 5a8c196273e10fdb";    String selectQuery =  "select username, password  from users where (username is not null and password isn't 'supersecret') ";
             try { ResultSet rs=stmt.executeQuery(query); /* executing the SQL statement */   while (rs .next()) System .out .println ("User found!!" );        } catch () {}    //Handling any possible exceptions  finally{con .....}      con ... Closing connections and statements if necessary    
            try { ResultSet rs = stmt.executeQuery(selectQuery);   /* executing the SQL statement */ while (rs .next()) System out .println ("User found!" + " :"+    } catch () {}  //Handling any possible exceptions finally{con ...} con...Closing connections and statements if necessary    
        }}          Closes brackets for code.        `