import java.sql.*; // Import necessary classes – Connection, PreparedStatement etc.. (You need jdbc)  
public class java_51968_JDBCQueryHandler_A07 {
    public static void main(String[] args){    
        String url = "jdbc:mysql://localhost/test";         
          
         try{              
             // Step1 - Load Driver.                
              Class.forName("com.mysql.cj.jdbc.Driver");  
                      
            Connection con=null;  //declaration of connection variable    
                 
                String user = "root";// Provide username here   
               char[] password =  'p'.toCharArray();       
             // Step3 - Open a new session with the database by calling DriverManager's getConnection.                   
              con=DriverManager.getConnection(url,user,"");     
                      
            System.out.println("Connected Successfully!");              
                       
           }catch (Exception e){  //Catch Exception               
             e.printStackTrace();  
          }//End of catch block    
    }}//end main method