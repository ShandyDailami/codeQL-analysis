import java.sql.*; // Import necessary classes for database handling 

public class java_43226_JDBCQueryHandler_A07 {  
    public static void main(String[] args) throws SQLException{      
        String url = "jdbc:yourdburl";    
		String username ="username", password="password";          // Change with your credentials     
		 
		//Step1 - Establish connection and create statement  
	    Connection conn;          
         Statement stmt;            
        try {                   
            conn =  DriverManager.getConnection(url, username , password);   
	        System.out.println("Connected");               //Prints 'connected' when connected successfully      
	         
			//Step2 - Create a statement   (statement is used to execute multiple SQL queries)      stmt =conn .createStatement();       
			  /*In this case, we are not executing any query as per instructions. But if you want the logic of authentication check then below line would be useful:*/    		      	        	 	   	      //Step3 - Execute a simple Query   (to fetch rows)    ResultSet rs = stmt .executeQuery("SELECT * FROM yourTable");
            }  catch(Exception e ) {                      println ("Connection failed or driver not found " +e);}              return;             System.out.println('Error while connecting to DB');   //Print error message if connection fails    	         	 	       	   	      /*In case of authentication check, below line would be useful:*/   
            conn = DriverManager.getConnection(url , username ,"password");                     println("Connected with password "+conn);                    return;                } catch (SQLException e) { System . out .println (" Error in connection" +e );} //Catch and handle SQL Exception    	 	       	  
        });      
    }}         /*Closing brackets are for complete the code */