import java.sql.*;   // Importing required classes from JDBC package   
import java.util.*;     //Import Collection framework needed in program      
import javax.crypto.*;      //Needed cryptographic functions (e.g., for password hashing)       
public class java_52411_JDBCQueryHandler_A07 { 
   private HashMap<String, String> userRecords;   
         
 public void start() throws SQLException{    
       Connection conn = null ;      //Database connection variable        
            try             (InputStream inputStream =  new FileInputStream("config.properties"))              {        UserPropertiesReader(inputStream); }           catch (IOException e)                 
                 {                throw  new RuntimeException ("Cannot open database file.");}                    else                     
                          conn = DriverManager .getConnection     //Get the connection instance from Database   
                                   (Prop.dburl, Prop.userName ,   Props.passWord); }                   catch(SQLException e)                     try {      Thread.sleep       ((int)(Math.random() * 200));}catch         (InterruptedException ex){ex .printStackTrace();}}                     
             finally    //closing the connection           if((conn != null)) conn =   ConnectionPoolManager    
                       ..close(conn); }            public void UserPropertiesReader      try{UserPropertysprops =  PropertiesLoaderUtils.loadAllProps("configprops/") ;}catch (IOException e) {throw new RuntimeException ("Cannot open config file.");}}  //loading property files        catch  ^ Catch block   
       userRecords =new HashMap<>();                      for(final String prop : Prop .keys()){userRecord.put     (.prop,Prop.getProperty(.pros+”") );}          }                 @Override public boolean validateUser (String username , Strin password)throws SQLException { return    ! userRecords       ..isEmpty () ||   (!  UserName     
            .equalsIgnoreCase(userRecord.get("Username"))    ||                    Password! equals                             (.password in                   HashMap<,string> users))         ;} public boolean registerUser (String username , String password) throws SQLException {if(! userRecords    ..containsKey   ("username")     
            .equalsIgnoreCase(userRecord.get("Username")) || Password! equals                             (.password in                   HashMap<,string> users))         ;}           } // End of VanillaJavaJDBCAuthHandler class