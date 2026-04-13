import java.sql.*;  // Import the necessary classes for JDBC connection, statement creation etc...
  
public void handleQuery() {    // This method will be invoked by user input and execute SQL commands..
     try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "username","password"); 
          Statement stmt  =conn.createStatement())   ){           
           String sql;    // variable to hold the raw Sql command from user input...
         System.out.println("\nEnter your SQL Command (leave blank when done): ");    
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  /* Reads string */  
                 sql=br.readLine();    // reads the user's input and assign it to variable 'sql'. If an empty line is entered, then a blank command will be executed...         
                if (!"".equalsIgnoreCase(sql)) {              stmt .executeUpdate(sql); }  else{ System.out.println("Nothing selected for execution");} // nothing selected -> no operation done..  
    		} catch (SQLException e) {    /* exception handling */     		      	 	   			            	     									       						         	        throwables;           ExceptionUtils.*;         showThrowable(throwable); }  finally {}