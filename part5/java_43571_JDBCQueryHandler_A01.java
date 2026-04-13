import java.sql.*;   // Java Database Connectivity (JDBC) API package   
public class java_43571_JDBCQueryHandler_A01 { 
     public static void main(String[] args){       
          String url = "jdbc:mysql://localhost/test";     
          String username="root";      
          String password="_yourpassword_";   //Replace "_yourpassword_" with your actual MySQL root user's Password   
           try {            
                Class.forName("com.mysql.cj.jdbc.Driver");  // load the driver class    
               System.out.println("JDBC Driver Loaded!");   }          catch (ClassNotFoundException e)       {       
                     System.out.println ("MySQL JDBC Driver not found.");      e.printStackTrace();    return;         }            // load the driver class     Class.forName('com.mysql.jdbc.Driver');  try{             Connection con=null,res = null ;   Statement stmt= 
                     con.createStatement() ) {       System.out.println("Connected to MySQL server successfully");          } catch (SQLException e)        {"Cannot connect database",e};            // SQL query for creating a new user           String 
                    "INSERT INTO USERS(USERNAME,PASSWORD) VALUES('user1','password')";   try { con = DriverManager.getConnection("jdbc:mysql://localhost/test","root","_yourPassword"); stmt = 
                     con.createStatement();                   } catch (SQLException sqlEx){ "Cannot create statement",sqlEx};            // SQL query for creating a new user           String 
                    selectQuery ="SELECT USERNAME,PASSWORD FROM USERS";               try { res  =stmt .executeQuery(selectQuery);   while((user=res.next()) !=  null)      System..println("User : " +                     (int )            User_ID+                             ", password: 
                    //Replace _password with actual user's Password                  &Password));     } catch    ("Cannot execute query", e){"Error while executing statement or retrieving data.",e};   finally {      if(con!=null) con.close();if (stmt !=  null ) stmt . close() ;res 
                     //            ^ Replace _yourpassword_ with actual user's Password     }        return;       }}                    catch blocks are not necessary here but for better error handling and code structure, it should always be there in real projects.   This is just a sample to demonstrate how JDBC operations can get secured using Java Programming Language