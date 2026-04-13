import java.sql.*; // For ResultSet & Statement objects

public class java_52646_SessionManager_A01 {   
     static String DB_URL = "jdbc:mysql://localhost/test";  
     static String USERNAME="root"; 
     static String PASSWORD="password";         
      
      public Connection getConnection() throws SQLException{            // Get connection to the database.   
         return DriverManager.getConnection(DB_URL,USERNAME ,PASSWORD);        }  
          
                 void startTransaction () {                           try  {            
                          con = this.getConnection();               ConcurrentHashMap<String,Integer> map =  new ConcurrentHashMap<> ( );            //open connection   
                                                                System.out.println("Connecting to " + DB_URL);       }   catch(SQLException ex){                            ExitProgram ("Cannot open Database" ,ex) ;          }} 
                          void stopTransaction () {                              try{ con .close();}                           finally     {}              // close connection and set errorCode in exception.                      if (errorcode != 0 ) throw new ExceptionInInitializerError("Database Connection can't be closed"); }      })}};               };    }); 
                             void ExitProgram(String ErrorMessage,Exception ex){        System.out.println(ErrorMessage + ":   \n"+ex);System.exit(1)};}       //Exit program if error occurs while executing the above code              }} ;