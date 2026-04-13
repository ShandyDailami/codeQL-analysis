import java.sql.*;   // For PreparedStatement, ResultSet 

public class java_52578_JDBCQueryHandler_A08 {    
    public static void main(String[] args) throws ClassNotFoundException, SQLException{       
         String url = "jdbc:mysql://localhost/test";         
		// Replace with your username and password.           
		 String userName="root",password="Password@1234567890$$$#%%^&*()_+~`}{r]|?><I;:"  ;     //Change it as per requirement     
         Class.forName("com.mysql.cj.jdbc.Driver");         
		 PreparedStatement pstmt = null;      	  			   	 									                   	   	     	        /*To avoid SQL injection attacks*/             
        try {                          
            Connection conn= DriverManager.getConnection(url,userName,password);                //Getting the connection                  
             String queryString  ="SELECT * FROM users WHERE username = ?";                    		   		//You should replace 'users' with your table name and also use parameterized queries for security        	   	 	     			    									   /*To avoid SQL injection attacks*/             	        pstmt=conn.prepareStatement(queryString);               
             pstmt.setString(1, "admin");                 //Setting the userName in Parameter         		   		/*You should replace 'user' with your actual column name for security */ 			    									   /*To avoid SQL injection attacks*/        	        ResultSet rs =pstmt .executeQuery();          
             while (rs.next()) {                            	//Reading data from database             	   	 	     										        //The code should be written according to the requirement               }                       	          pstmt.closeConnection()                     printStackTrace                      System.out                       }}catch(Exception e){e.printstacktrace}  
                   };     });  /*To avoid SQL injection attacks*/}};             try {pstm = conn.prepareStatement("SELECT * FROM users WHERE username='?"); pstmt .setString (1, "admin"); ResultSet rs  = null;}catch(Exception e){e.printStackTrace();}
        } catch (ClassNotFoundException | SQLException e) {  //Handling exceptions            throw new RuntimeException("Failed to open connection.", e );}};              try{ pstm = conn .prepareStatement ("SELECT * FROM users WHERE username='?'");pstmt..setString(1, "admin") ; ResultSet rs  = null;}catch (Runtimeexception) {e.printStackTrace();}
    }   };  }}      catch({ Exception e ){ System.out.println("Database Connection Failed!"+E);}};                  try     //To handle SQL Exceptions                 printSQLException(sqlEx){System . out. Println ("Error Code: " + sqlExcenion ,e );}           
    };  }}      catch ( Exception e ){ System .out.println("Cannot select in users table"+E);}}}   }}};     //To handle other exceptions                 printSQLException(sqlEx){System out. Println ("Error Code: " + sqlExcenion ,e );}