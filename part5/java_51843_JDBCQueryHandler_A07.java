import java.sql.*; // Import necessary Java libraries 
  
public class java_51843_JDBCQueryHandler_A07 {    
    public static void main(String[] args) {      
        String url = "jdbc:mysql://localhost:3306/mydb";         
          
         try (Connection con=DriverManager.getConnection(url,"user_a", null)) // using Driver Manager to connect the database server   
            { 
                System.out.println("Connected Successfully");     
             }       catch (SQLException e)     // Catching SQLExceptions if any occur          
               {         
                 printError(e);        
              }   finally                  
       		{                     
		   	// Close the connection regardless of an exception occurred or not. 
                try{if(con != null){ con.close();}}catch(SQLException e){printError(e);}    			            	   	       	 	}                                                      					      				                     }                  }}   // End main method and closing braces                   	                     		         														                                                                    "))