import java.sql.*;   // Import Statement for JDBC connection, PreparedStatement & ResultSet objects    
    import javax.sql.DataSource;       //Import Data Source Factory and Connection interface     
public class java_52694_JDBCQueryHandler_A03 {                   
        private static final String DB_URL = "jdbc:mysql://localhost/test";  
            public  Statement stmt ;                 
           try{                  
                Class.forName("com.mysql.cj.jdbc.Driver");             //Load the driver         
               DataSource ds =  new com.zaxxer.hikari.HikariDataSource();//Setting up connection pool        
                    ds.setJdbcUrl(DB_URL);    
                Connection con =ds.getConnection("username", "password");   //Connect to database          
                  stmt  =con.createStatement();                       /*Create a Statement object*/           
               ResultSet rs =  stmt .executeQuery ("SELECT * FROM USERS WHERE AGE > '30' ");  //Execute the Query       */          }      catch(Exception ex){   System.out.println("Error in DB Connection");}     finally{           if (stmt != null)             closeConnection();            }}   
private static void closeConnection(){                           try {if (conn != null ) conn.close();  //Close connection              if (stmt !=  null) stmt .close();}}catch(SQLException se){ }                 catch (Exception ex){   System.out.println("Error in Closing Connection");}     }}