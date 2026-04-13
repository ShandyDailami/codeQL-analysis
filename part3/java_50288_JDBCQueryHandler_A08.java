import java.sql.*;  // Import necessary classes from JDBC package  
public class java_50288_JDBCQueryHandler_A08 {   
     public static void main(String[] args) throws SQLException{         
           String url = "jdbc:mysql://localhost/test";           
           Connection con=DriverManager.getConnection("url",user,"password");              //Get connection to database            
               Statement stmt =con.createStatement();     			//Create statement object                  
               	String sql  ="SELECT * FROM Employees WHERE id > -1 ";   	  	 	       									 			    								        	      " + (2*int)';'}; // This will fail in mysql due to lack of quotes around the column name and 'id > 0;'.		              int affectedRows = stmt.executeUpdate(sql);       
          }                      DriverManager                  con=null ;   printStackTrace();  if(!con.isClosed()) {            System . out .println ( " Connection is closed" );             ((java SQLException)                null).printSQLExcetion ()                          	} catch    java sql exception;          	catch(sql statement ){               }
       try             ^                                                  finally{} 		         			        closeConnection(){ con.close();}     					  	  if (con !=null){try { runQuery() ;     }}                // Query execution            throw new ExceptionInInitializerError("Cannot initialize the Connection object");}}catch(Exception e)