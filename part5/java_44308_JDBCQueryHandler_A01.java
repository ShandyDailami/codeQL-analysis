import java.sql.*;   // for JDBC classes like Connection, Statement and ResultSet   
     import javax.sql.DataSource;  //for interface DataSource which is required by DriverManager to create a data source(connection pool) with the DBMS
      
public class java_44308_JDBCQueryHandler_A01 {
      public static void main (String args[]){  
          connectToDatabase();    }    
         private Connection conn = null;  // connection object for database operations.       
           DataSource datasource ;// interface to create a data source(connection pool) with the DBMS, which has been set in our code using properties file here      
            public void loadDataSource() {   /* function that loads driver and creates Connection */    
                try{  //try block for exception handling.    it will be executed even if an error occurs while executing inner blocks like catch-catch or finally .     
                    Class.forName("com.mysql.cj.jdbc.Driver");//loading MySQL JDBC driver  
                      String url = "jdbc:mysql://localhost/test";     //database URL    where test is database name (you can change it as per your requirement)  .      string for username and password, you should use those properties file in real scenario like `prop.load(new FileInputStream("dbCredentials"))`
                    Properties props = new Properties();   /*set the property values*/    
                     //props.setProperty("user","your_username");    set your user name  here as per requirement      prop.setProperty("password", "YourPassword") ;// Set password to connect database .       
                  conn= DriverManager.getConnection(url, props);   /*Get Connection*/     }       catch (Exception e){ System.out.println ("Error in connecting with Database");  e.printStackTrace();}      }}    //end of loadDataSource function            try {          if ((conn = datasource .getConnection()) != null) {         return;   print a success message and end here        } catch (SQLException ex){ System.out.println ("Error in connecting with Database");     ex.printStackTrace();}  }} //end of main function