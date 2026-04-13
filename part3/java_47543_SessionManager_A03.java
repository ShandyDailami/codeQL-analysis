public enum DBType { MYSQL }  // we'll use MySQL for simplicity here but the principle remains same.   
   public class java_47543_SessionManager_A03{    
        private Connection connection;      // this is our only way to interact with database, so it’s safe and secure as long at least once!        
       DBType dbtype = null ;  // type of Database we're using - for simplicity I am assuming MySQL.   You can also use JDBC Driver Manager from Oracle or Postgres if you are planning on more types     
        private static SessionManager instance;    
             public Connection openSession(){         
                switch(dbtype){              
                    case MYSQL:                 // we'll be using native mysql driver for simplicity.        
                        try{                     // connect to database and get connection object  
                            Class.forName("com.mysql.jdbc.Driver");  // load the MySQL Driver, this is safe if already loaded in our environment           
                             }catch (ClassNotFoundException cnfe){          System .out.println ("MySQL JDBC Driver not found " +cnfe);         return null;     };        try{                connection = DriverManager   .getConnection("jdbc:mysql://localhost/testdb","user1234567890",  // connect to database            
                            "password"); }catch (SQLException se){          System.out.println ("Cannot get JDBC Driver instance for MySQL" +se); return null;      };                 break;}       case ORACLE:                try{                     connection =DriverManager .getConnection("jdbc:oracle://localhost/oratest", "user1234567890","password");  }catch(SQLException se){ System.out.println ("Cannot get JDBC Driver instance for Oracle" +se); return null;      };break;}                 
               default :System . out   . println("No valid DB type specified " );       break ;}         //close connection     if (connection !=null) { try{    Connection closeConnection(){  System.out.println ("Closing Database Connection");          connection = null; } return closeConnection;}catch(SQLException se){System.out.print("Can't disconnect from database due to " +se);      }}