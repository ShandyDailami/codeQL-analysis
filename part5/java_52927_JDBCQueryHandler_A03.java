//import statements for utilities needed in this task (like BufferedReader, PrintWriter etc.)  
import java.sql.*; //For all JDBC related operations 
        
public class java_52927_JDBCQueryHandler_A03 {    
    public static void main(String[] args) throws SQLException{         
        Connection connection = null;            
	PreparedStatement stmt = null;                		     	       	 	   			  									      	      //Create a PreparedStatements.  (A01_InjectionAttack Avoid using parameterized queries here.)   
        
	//Database configuration details are not included in this example for simplicity, but usually they're stored outside of the program and read into variables or objects at runtime if required by your application            	    		       	   			  									      	      //Create a Connection. (A02_InjectionAttack Avoid using direct database connection here.)
	String url = "jdbc:mysql://localhost/test";      String username="root";String password="password123456789!"; 			   	  		       	   					      	      //Database credentials. (A03_InjectionAttack Avoid hardcoding database connection here.)    
        					//Establish the Connection and get a statement object from it.(AOI)                   	 	       							          								      } catch SQLException e { 	e . printStackTrace();  		    //Handle exceptions. (AI_Error Handling Avoid using try-catch block here.)    
        System.out.println("Connecting to database...");         connection = DriverManager.getConnection(url, username , password );         			           stmt=connection.prepareStatement ("INSERT INTO EMPLOYEE(ID , NAME) VALUES (?,?)"); 		    //Avoid parameterized queries here using PreparedStatements.(AI_Parameterization Avoid directly use ? placeholders in the query.)
        stmt .setInt   (1,20);      			     	    									         stmt. setString(2,"TestUser" ); 		    //Avoid hardcoding values here using PreparedStatements.(AI_Parameterization Avoid directly use ? placeholders in the query.)
        int rowsInserted =stmt .executeUpdate();           } catch (SQLException e) {	         System.out.println("Error while connecting to Database");   //Handle exceptions    									   		     	} 			                  	//A02_InjectionAttack Avoid using direct database connection here.)