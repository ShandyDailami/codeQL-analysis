import javax.sql.DataSource; // assuming you're using a DataSource that implements java.sql.* interface (like DBCP or C3P0)  
public class java_44040_JDBCQueryHandler_A01 {    
    private static final String SQL_SELECT = "select * from users where username=?"; 
      
    public void run(DataSource dataSource, String userName){         
        try{          
            Connection connection =  dataSource.getConnection();         // Step1: Obtain a Database connection    
            
            PreparedStatement statement = connection .prepareStatement (SQL_SELECT);   //Step2 : Construct the SQL Statement  --> using ? placeholders for userName parameter     
                                                                          
            /*You can use setter methods or directly pass values, this is just an example. */       
        	statement.setString(1 ,userName );                     		   			         									   // Step3: Execute the SQL Statement  --> Pass in a value (in your case user name) for ? placeholder     	   
                                                                                                                      						    	 															      	      } finally {            if (connection != null){                connection.close();         }} catch(SQLException e ){           System.out.println("Error while executing the SQL query: " +e);}};  // Step5 : Handle any exceptions that may occur