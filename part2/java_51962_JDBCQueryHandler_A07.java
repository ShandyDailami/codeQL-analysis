import java.sql.*;
public class java_51962_JDBCQueryHandler_A07 {  //replace 'A07_AuthFailure with your actual table name and field names if they are different.'  
    private static final String url = "jdbc:mysql://localhost/test";      // replace the above URL as per database details like host, port etc.    
    private static final String username ="root";       //replace 'user' with actual user name and password (use root if your db is MySQL)  for authentication failure case  
    public Connection connectToDB(){       
         try {          
               Class.forName("com.mysql.cj.jdbc.Driver");     // Load the Driver     
                return DriverManager.getConnection(url, username,"");      
          } catch (ClassNotFoundException e) {             
                  System.out.println ("Error in loading the driver" +e);   
                      return null;           
           }       
   } 
     public void closeDBconnection(Connection connection){             //Method to Close DB Connection     
         if(connection !=null ){                                 
                try {                                              
                        connection.close();                              
                   } catch (SQLException e) {                         
                            System.out.println ("Error in closing the database" +e);  
                    }       
       }   
     public Boolean validateUserCredentials(String username, String password){         //Method to check login credentials against DB     
           Connection connection = connectToDB();                 
              if (connection == null) {                          
                      System.out.println ("Cannot Connect");          return false;  
               }       
             try{  PreparedStatement preparedstatement=     connection.prepareStatement("SELECT * FROM A07_AuthFailure WHERE username = ? AND password  =?");           //replace 'A07_AuthFailure' and the actual table name, fields etc        
              preparedstatement .setString(1 ,username );         
               preparedstatement .setString(2 ,"password");     	  		      	       			    	   				   						        } catch (SQLException e) {                    System.out.println ("Error in user credentials check" +e); return false;           	}         finally{                  closeDBconnection( connection );                }}