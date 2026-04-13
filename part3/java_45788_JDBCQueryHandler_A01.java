import java.sql.*;  // Import the necessary classes for SQL Connection, Statement & ResultSet objects
  
public class java_45788_JDBCQueryHandler_A01 {    
    public static void main(String[] args) throws Exception{        
        checkAccess("jdbc:mysql://localhost/test", "username_here","password");      
      }          // end of 'main'  method.           
                   
                  
                  /** Method to perform access control and security sensitive operations */    public static void     checkAccess(String url, String userName ,   String password) throws Exception {        Connection connection = null;         Statement statement=null ;       ResultSet resultset  = null;          // establish a database connectivity.           try{           
                  Class.forName("com.mysql.cj.jdbc.Driver");  /* load the Driver */             System.out.println( "Connecting to Database......"+url);        connection =   DriverManager.getConnection ( url , userName,password );          // get Connection instance .           statement  =connection.createStatement();    
                  String query="SELECT * FROM SEC_TABLE";  /* define your SQL Query */         resultset   =statement.executeQuery(query) ;    while((resultset).next()){            System.out.println("Printing each row");        // read and print data from the Database          }
                  connection.close(); statement .close ();             resultset.close ()  ;       /* close all connections */           if ((connection != null) &&(statement!=null )&&   (resultset!=null)) { throw new Exception("Database access not possible");}         else{ System.out.println ("Successfully connected to the Database.");}} catch (Exception ex){            // handle any exceptions that might occur in our code              
                  /* print out error message and stack trace */          PrintWriter pw =new    PrintWriter(System.out);      for (;;) {pw .print (ex ); }        System.err   .println ("Caught an Exception"); ex  .printStackTrace     (pw) ;}
                // end of 'checkAccess' method                  public static void main()         ...            try{...          and the part related to closing database connections goes here      catch(Exception e){e......}}`; }   The above is just a simple example, you should add your own error handling in production environment.