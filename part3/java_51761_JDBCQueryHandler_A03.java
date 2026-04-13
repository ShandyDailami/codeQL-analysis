import java.sql.*;   // Import Statement class java_51761_JDBCQueryHandler_A03 create statement objects 
                    // DriverManager is static so there isn’t need of creating object for the driver instance variable and also avoids sql exception in constructor   
public class JDBCQueryHandler {    
 public Connection connectToDatabase() throws SQLException, ClassNotFoundException{  
       String url="jdbc:mysql://localhost/test";  //replace with your own database URL         
       String username = "root";//change according to the user in mysql   
         String password = "";               
           boolean bAvoidEnterpriseIds =  true;            Class.forName("com.mysql.cj.jdbc.Driver");   Connection con=null,st= null ;  try      {con=  DriverManager.getConnection(url ,username,password);     }        catch (ClassNotFoundException e)   
           {       throw new SQLException("Cannot load 'class' driver",e );}             //catching the exception in case of loading class from database   Try            {st= con .createStatement();      System.out.println ("Connected to Database"); }         catch (SQLException ex){  Logger.getLogger(JDBCQueryHandler.class.getName()).log(Level.SEVERE,"Error connecting with the DB",ex);}  
return null;    // Return statement in case of connection failure      else           return con ;        }}