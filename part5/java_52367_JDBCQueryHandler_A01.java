import java.sql.*;   // Import required Java libraries   
class java_52367_JDBCQueryHandler_A01 {    
       public Connection getDBConnection(String dbName, String dbUser,     
                String dbPassword) throws ClassNotFoundException, SQLException{         
           Class.forName("com.mysql.cj.jdbc.Driver");  /* Loading driver */  
            //In order to connect we'll use the following URL: jdbc://localhost/database_name     
		    String connectionUrl="jdbc:mysql://localhost/"+dbName;    
           Connection con = DriverManager.getConnection(connectionUrl, dbUser ,  dbPassword);      
	   return con ;        // Returning the database connection          }};         };            /* Call getDBConnection method */    if (con==null) { throw new Exception("Cannot find the driver");} else{System.out.println("\nConnected to Database\n");}}  catch(Exception e){ System.out.println ("Error while connecting with the database"+e); }  
		}     // End of getDBConnection method };         /* Call main */    public static void      Main (String args []) { try{       DBConnection db = new DBconnection();            
           Connection con=db .getDbConnection("test","root", "password");  if(con !=  null)   System.out.println("\nSuccessfully Connected\n"+    ); else                      } catch (Exception e){System     . out      . println ("Error while connecting with the database, check it again." +e);}}