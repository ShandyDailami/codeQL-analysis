import java.sql.*;   // For JDBC (Java Database Connectivity) API   
  import javax.crypto.*;   //For Bcrypt Hash function for password hashing    
  public class java_50761_JDBCQueryHandler_A07 {     
       private static final String URL = "jdbc:mysql://localhost/test";//Replace with your database details, e.g., jdbc:sqlserver://your_host;databaseName=dbname   
        private static final String USERNAME ="root", PASSWORD =  ""; // replace password accordingly    
         public Connection connectToDB() {     
             try{      
                 Class.forName("com.mysql.cj.jdbc.Driver");//Load MySQL Driver   for JDBC 8 or later, it's the same as mysql-connector/java package but has fewer bugs   
                  Connection conn = DriverManager.getConnection(URL , USERNAME , PASSWORD);      //Establish connection     if there are any database specific credentials then replace them otherwise use defaults  
                 return  conn;        }catch (ClassNotFoundException e) {       System.out.println("Load driver error : " +e );return null;} catch(SQLException ex){System.out.print ("Connection Failed! Check output console");	return null ;}     // end try     
         }//end method   
   public String hashPassword (String passwordToHash) { 
           MessageDigest md;      
            byte[] hashedBytes;       
          try{                m = MessageDigest.getInstance("SHA-256");             dbs=m .digest(passwordtohash);     } catch (NoSuchAlgorithmException e){System.out.println ("Hash Algo not supported!" +e );}       return null;   
        //return hashedBytes;   for further security use bcrypt or similar password storage and comparison methods 
            }}// end class VanillaJdbcQueryHandler     }