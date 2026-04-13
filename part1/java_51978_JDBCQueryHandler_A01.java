import java.sql.*;   // Import Statements for Database Accesss in Java   
    
public class java_51978_JDBCQueryHandler_A01 {     
        public Connection getConnection() throws ClassNotFoundException{      
            String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  /* Your SQL Server Driver */        
             //Setting up the database connection  
          Class.forName(driver);   
           return DriverManager.getConnection("jdbc:sqlserver://localhost;database=testdb","username", "password");     }      public void selectAll() throws SQLException{  /* Getting Connection from getConnection method */      
            Statement stmt = null ;        try {stmt  = getConnection().createStatement();}catch (SQLException e){e.printStackTrace();return;}   String sql;    //Select all query     sqli="SELECT * FROM Employee";      ResultSet rs=null;  /* Executing the Query */        
          System.out.println("Selecting rows from table employee");        stmt = getConnection().createStatement() ;       try{rs  =stmt .executeQuery(sql);}catch (SQLException e){e.printStackTrace();return;}   while ( rs.next()) {    //Print all data
         System.out.println("Selecting rows from table employee");  }     catch (SQLException sqlEx)      {} finally{stmt .close() ;}}        public static void main(String[] args){ new JDBCQueryHandler().selectAll();}       /* This is the test driver, you may replace or add to it as needed. */