import java.sql.*; // Import the necessary Java libraries or frameworks here if any are required e.g SQL, Statement etc  
public class java_48362_SessionManager_A08 {   
     private static Connection conn; /* A simple Database Connection */        
      public void openSession() throws Exception{         
           try 
            {       
                Class.forName("com.mysql.cj.jdbc.Driver"); // Load the database driver      
               String url = "jdbc:mysql://localhost/testdb";    /* Database URL */             
                 conn =  DriverManager.getConnection(url, "username",  "password" );  
            } catch (ClassNotFoundException e) {           throw new Exception("MySQL Java Connector couldn't be loaded."+e);     }       finally{          if((conn != null))    System.out.println("\nDatabase Connection Established.");      else  System.out.println("\nUnable to establish Database connection");   }}
            catch (Exception ex) {throw new Exception("Error in establishing database session: "+ex);}         finally{       if ((conn != null)) conn.close();     }          // Close the Connection after use      return;    };  /* End of openSession() method */        public void checkIntegrity(){  
           try {           
               Statement stmt = conn.createStatement( );            
              ResultSet rs =  stmt.executeQuery("SELECT * FROM USERS");         while (rs.next())          // If any rows were returned by execute query then do the following...    System.out.println("\nUser Name : " + rs.getString("username"));   } catch(SQLException se) { throw new Exception ("Error in reading data."+se);}      finally{       if ((stmt != null)) stmt.close();     }}  /* End of checkIntegrity() method */
    public static void main (String[] args){          SessionManager sm = new SessionManager( );           try {sm.openSession();   // Open session before checking integrity         sm.checkIntegrity(); } catch (Exception ex) { System.out.println("Error occurred: " +ex);}}