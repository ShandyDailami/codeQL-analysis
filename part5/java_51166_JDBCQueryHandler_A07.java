import java.sql.*;   // Import necessary SQL classes here   
public class java_51166_JDBCQueryHandler_A07 {    
private Connection conn;      
     
 public void connect(String url, String username, String password) throws SQLException{           
          this.conn = DriverManager.getConnection(url,username,password);          
 }   //End of the 'connect' method       
 
// Creating a new user in database    	      		     	     	 	   			   	       									         public void addUser (String name , String pass) throws SQLException{         							             this.conn = DriverManager.getConnection(url,username,password);             								   }                           //End of 'adduser' method
 
//Method for user login validation	    		     	   			   	       									         public void authenticateUser (String name , String pass) throws SQLException{           this.conn = DriverManager .getConnection(url, username, password);            	}                              	// Ends the 'authenticatuser' method
  //Creating a new task in database	    		     	   			   	       									         public void createTask (String name , String pass) throws SQLException{        this.conn = DriverManager .getConnection(url, username, password);            }                    	// Ends the 'createtask' method
  //Method to retrieve all tasks from database	    		     	   			   	       									         public void getAllTasks() {                  PreparedStatement pstmt;                try{                 this.conn = DriverManager .getConnection(url, username, password);              PreparedStatement stmt= conn.prepareStatement("SELECT * FROM TASK");             ResultSet rs= 
stmtsetup for all tasks in database	    		     	   			   	       									         public void getAllTasks() throws SQLException{          this.conn = DriverManager .getConnection(url, username , password);           PreparedStatement stmt= conn.preparestatement("SELECT * FROM TASK");            ResultSet rs= 
stmtopen for all tasks in database	    		     	   			   	       									         public void getAllTasks() throws SQLException{          this