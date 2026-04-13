import java.sql.*; // Import necessary classes for interacting with a MySQL Database  
class java_47785_JDBCQueryHandler_A01 {    
    public static void main(String[] args) {         
        Connection conn = null;          
         try{             
             String url="jdbc:mysql://localhost/testdb";     
 			String username= "root";       //Change accordingly to your database credentials  
			 String password=  "";    		//If you want the default root access, leave it blank. Otherwise provide a valid one   	 
              conn = DriverManager.getConnection(url ,username,password);         	     	   	       
             Statement stmt  =conn .createStatement();            //Create statement  		     			      									 								    		//Only to be used in case of select queries                   
           }catch (SQLException sqlEx){                            //Handle exceptions that can occur during the connection process.   	 	     	   	       								}          finally{             if(conn!=null) { try{ conn .close();} catch (SQLException se ) {} } 		     	  			      									    
        }}`;//