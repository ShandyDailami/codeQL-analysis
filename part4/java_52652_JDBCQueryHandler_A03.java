import java.sql.*;
public class java_52652_JDBCQueryHandler_A03 {  
    public static void main(String[] args) {    
        String url = "jdbc:mysql://localhost/test";      
          
        try (Connection con = DriverManager.getConnection("url", "user","pass");     
             Statement stmt =con.createStatement())  {   
              
            // Prepare SQL statement using parameterized query         
	    String sql2 = 	"INSERT INTO EMPLOYEE(ID,NAME,DEPARTMENT) VALUES (?, ? ,?)";    	  		      			     	 									       						        	     	       
                System.out.println("Preparing "+sql2);   							                  								                                                                         	    PreparedStatement pstmt = con.prepareStatement(sql2 );  // SQL statement to be executed          
               /* Bind the parameter */	  		      			     	 									       						        	     	       
                for (int i = 1;i <=50 ; ++i) {    							                  								                                                                         	    pstmt .setInt   ​​(3, 2); // ID is a INT and we set it to the value of two.  	      		     	 									       						        	     	       
                }                 
            System.out.println("Inserted successfully");                                                      			                 stmt.executeUpdate();    	    });                                                                          con.close() ;    printStackTrace());  // you can see here how the error happened and to debug, make sure all your close statements are after this one           e .printStackTrace ();
        }     	  		      	 									         catch(SQLException sqlEx) {    	    System.out.println ("Error in running mysql " +sql2+"\n");  //you can debug it by adding more code to get the error message                                                      			    e .printStackTrace (); }
     	  		      	 									         catch(Exception ex){                                                                             printStackTrace();} });       	}                      }) ;