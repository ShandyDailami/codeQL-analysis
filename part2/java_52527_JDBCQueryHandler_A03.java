import java.sql.*;   // For database operations, result sets etc., they're a part of jdbc library   
    
public class java_52527_JDBCQueryHandler_A03 {         
        public static void main(String[] args) {        
            String url = "jdbc:mysql://localhost/test";     
                String username="username_here";              // Your MySQL Username, should be updated 
               String password="password_here";            		//Your MySQl Password ,should also be passed by command line arguments   
                      try {    
                            Connection conn = DriverManager.getConnection(url, username, password);     
                              System.out.println("Connected to the database");       
                               String sql="SELECT * FROM users";         //SQL statement          
                                     Statement stmt  =conn.createStatement();           
                                      ResultSet rs =  stmt.executeQuery (sql) ;   
                                    while(rs.next())   { 	       	   		//printing each column data      
                                         System.out.println("ID : " + rs.getString('id'));         //You must use 'String' not just 'int', because result set methods return objects of type object and cannot handle int directly     	 
                                           }       			 		   		//printing each column data         									  															    						      	   	}                             catch (SQLException e) {             System.out.println("Error while connecting to database");         e.printStackTrace();            }                      finally{ if(conn!=null){ try{ conn.close();}catch(SQLException ex){ex.printStackTrace() ;}}   
  //closes the connection after operations are done  									    				}     	      		                                   });         `