import javax.sql.DataSource;   // This is where we are going with Data Source and Driver Manager 
import java.sql.*;    //For all database operations, ResultSet etc.,    
                      
public class java_52755_JDBCQueryHandler_A03 {
       private static final String URL = "jdbc:mysql://localhost/test";     
       private static final String USERNAME="root";  
       private static final String PASSWORD  = "";    //Empty password if we are using root user, 
                                                       //otherwise provide the MySQL username's DBPassword.    
        DataSource dataSource;                     //This will be an instance of our created class 'MySQLInitialContext'.        
      public void setDataSource(DataSource dataSource) {            
            this.dataSource = dataSource;}   }  ;    /* */      `java'