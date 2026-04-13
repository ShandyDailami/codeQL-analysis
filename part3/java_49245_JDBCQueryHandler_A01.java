import java.sql.*;   // SQL related classes imports here...    
class java_49245_JDBCQueryHandler_A01 {  //main class begins   
public static void main (String[] args){     
// Create a connection to the database         
try{              
Class.forName("com.mysql.cj.jdbc.Driver");   //Load MySQL driver          
Connection conn = DriverManager.getConnection( "jdbc:mysql://localhost/testdb?useSSL=false", "username","password" );    }              catch (Exception e){       System.out.println ("Error in connecting to the database :  ");     return;   }} //end of main function           
// SQL query and call PreparedStatement             try{               String sql = "INSERT INTO users(id, username) VALUES({0}, {1})";                     Connection conn= JDBCQueryHandler.conn ;                  CallableStatement stmt  =    conn .prepareCall (sql);              //set parameters                 int id = 2;String uname   =   “John”;          
stmt.setInt(1,id );              	        		     	 			    				       stmt. setString(2,"john");                           	       	} catch {          System .out.println ("Error in executing SQL query: ");    return;}//end of try-catch block  } //End method