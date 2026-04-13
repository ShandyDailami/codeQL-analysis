import java.sql.*; // For Connection & Statement 
   import javax.transaction.*;//For UserTransaction, SecurityException etc.   
    
public class java_52794_SessionManager_A07 {     
       public static void main(String[] args) throws Exception{            
        System.out.println("Starting connection...");               
           try (Connection conn = DriverManager.getConnection('jdbc:mysql://localhost/mydatabase','user', 'password');  //Establishes the Connection         
                  UserTransaction utxn  = conn.setAutoCommitTransaction();) {                
               System.out.println("Autocommits transaction...");                  
                try (SessionFactory sf = new org.hibernate.cfg.Configuration().configure().buildSessionFactory())  //Establishes Session Factory         
                      ;   utxn .begin()){                                 
                          /* Your code here */    }                        
               System.out.println("Transaction Commit");            
                utxn .commit();                                   //Commits the Transaction          
            } catch (SecurityException se) {                 
                 throw new Exception(se);                   
              }  finally{                                       
                   if ((conn != null))                     try   conn.close() ;                             else                      System.out.println("Failed to close Connection");                }}catch     //Catch block for the given exception           catch (Exception e) {e .printStackTrace();}};           `    }