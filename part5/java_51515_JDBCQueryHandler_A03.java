import java.sql.*;   // Import necessary Java libraries here...standard ones for JDBC operations   
    
public class java_51515_JDBCQueryHandler_A03 {  //Define your own unique name, based on A03_Injection rule!
                                          
	private Connection connection;       
	                            private final String url = "your-url";   //Insert here the relevant database URL.     
	    private final String username="username", password="password";  // Insert your credentials inside quotes for security reasons, no need to say sorry!   
         public java_51515_JDBCQueryHandler_A03() {                             //Constructor method that will set up our connection object    
		 try{                                                                  
			 this.connection = DriverManager.getConnection(url , username , password);        }              catch (SQLException ex){  Exceptions are not okay, just log and move on!      System.out.println("Cannot connect to the database");}   	 	          	}                         
     public void close(){ if ((this.connection != null)) try { this.connection .close();}} //Close our connection in any case (even if an exception was thrown)  }   private String runQuery(String query){      PreparedStatement stmt =null;          try{stmt  = connection.prepareStatement(query);         ResultSet rs = 	    		      	 
	    this .runQuery("SELECT * FROM yourTable"); //Here you can put the SQL Query, no need to say sorry!  }    if (rs != null) {             while ((result = stmt.executeUpdate()) > 0){                   doSomethingWith(result);}}} catch (SQLException ex ){   Exceptions are not okay too - just log and move on}    
            System.out.println("Cannot run the query");}}                try  //A new scope in which we can handle SQLExeptions, using a Try-Catch block is good practice for this          } catch (SQLException ex) {System. out .printlns ("There was an error" +ex);}}}