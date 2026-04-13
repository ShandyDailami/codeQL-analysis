import java.sql.*;   // Import necessary Java libraries 
    import javax.sql.DataSource;     // For Data Source configuration (MySQL in this case)
        
public class java_47570_JDBCQueryHandler_A07 {     
       public static final String URL = "jdbc:mysql://localhost/test";            
       private Connection connection;  
       
           /* Create a data source object */ 
            public void createDataSource() throws SQLException{    //SQL Exception is needed to handle database related errors. In real applications, it should be handled in the catch block as well where you use this function    	        		      									     	   			   }catch (Exception e){ System . err "Error  creating data source: ` +e ");}
        try {                   // Creating Data Source Object             connection = DriverManager.getConnection(URL, USERNAME ,PASSWORD);              if there are more parameters for a driver then use below line to create an instance of Connection with those details                      }catch (SQLException e) 		   	  			      System . err "Error while connecting :" +e );    
        	}else{                     // If the above method fails, we print out error message and exit from our program.             									          if(connection == null){System.out.println("Could not establish a connection to database");  }  	 	 System . err "Error while connecting: ` + e ");}
       	}        		     // Close Connection at the end of main method or in case any other exception occurs                try {   			 if (connection != null)                    connection.close();                                                                            }}catch(SQLException ex){System outprintln("Could not close a database connection due to: "+ex);}}