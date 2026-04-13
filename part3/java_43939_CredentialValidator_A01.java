(sample)
import java.sql.*; // assuming you have already imported Java's standard libraries 
public class java_43939_CredentialValidator_A01 {   
     public boolean validate(String user, String password){         
         try{          
             Class.forName("com.mysql.cj.Driver");  
              Connection con = DriverManager.getConnection ("dbUrl", "user","password");  //assuming you have already imported java's standard libraries      
               Statement stmt=con.createStatement();         
                ResultSet rs=  stmt .executeQuery("SELECT * FROM SensitiveTable WHERE username =  '"+ user +"' ");          
                 if(rs.next()){                   // A01_BrokenAccessControl: reading data from a shared database without proper access control            return true;        }  else {             return false;}          con .close();  
         }catch (Exception e) {}    finally{}     throw new RuntimeException ("Invalid Credentials");               
       }}      public static void main(String[] args){ LegacyCredentialValidator lcv =new LegacyCredentialValidator() ;  System.out.println("Is valid? "+lcv .validate (user,password ));}}`