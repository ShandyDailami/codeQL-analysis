import java.sql.*;  // Import necessary Java libraries for database connectivity and JDBC communication  
class java_47659_SessionManager_A03 {    
    public static Connection con = null;          // Database connection variable       
                                                                          
      /* This method will establish the DB connection */                            
         private void createConnection()                                                      
                 throws SQLException, ClassNotFoundException                           
            {                 
                String url="jdbc:mysql://localhost/test";                  
            	Class.forName("com.mysql.cj.jdbc.Driver");          // Loads the MySQL driver  
         con = DriverManager.getConnection(url,"root","password");     /* Create a connection to database */    } 
                                                                          
        public static void main (String[] args)                                               throws SQLException, ClassNotFoundException                             {                   createConnection();                                   Main obj=new Main();                              //Creating object of the class         
         ob.createSession( );                                  System.out.println("New Session Created"); }  });       };                      public static void new_session()                                                                     try{Maintenance mnt = (ob) con.prepareStatement ("CREATE SESSION",                                           Connection.TRANSACTION_READ_COMMITTED);                 
         ob .executeUpdate();                    System.out.println("Session created"); } catch(SQLException e){System.err      "Unable to create session: {}".format (e));  }}                   public static void close() {                                                                                                              try{Maintenance mnt = con.prepareStatement ("CLOSE CURRENT SESSION", Connection.TRANSACTION_READ_COMMITTED); ob .executeUpdate(); System   
         outprintln("Session Closed"); } catch (SQLException e){System.err "Unable to close session: {}".format(e));}};  };                      //Main Class ends here