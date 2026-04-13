import org.springframework.jdbc.core.*;   // Importing spring's jdbc template class java_44718_JDBCQueryHandler_A03 provides functionality of CRUD operations   
public class JDBCQueryHandler {     // Main Class Declaration     
private static final String URL = "jdbc:mysql://localhost/test";  /* Database url */      
// Username and password for the MySQL database.   Note that you must change these values accordingly to your own setup         
 private static final String USERNAME="root";     // User Name of MySql user     
private static final String PASSWORD = "password";    /// Password associated with username       
  public JDBCQueryHandler() {   }       /* Constructor for the class */        
public Connection getConnection(){          /** Method to return a connection object*/    
 try{              // Begin Try block     
           Class.forName("com.mysql.cj.Driver");             /// Loading MySQL Driver           
                    System.out.println(this+"Created database connection...");         /* Creates the mysql conn */         
                   return DriverManager.getConnection(URL,USERNAME ,PASSWORD );      /** Returns a db Connection Object*/   }               // End Try block    catch (SQLException | ClassNotFoundException e) {e.printStackTrace();}  Return null;     **/            /* Catch Exception */             
             }}       The main Method starts here: Main                          public static void                                                       *main(String[] args){                         JDBCQueryHandler jdbc = new                           // Instantiating an object of class    }                   QueryRunner qr =  *** (new SQLQueryBuilder());  try{      /** Starts Try block */               
   if (!jdbc.getConnection().isValid()) {        /* Checking the connection status to make sure it is valid or not*/         System .outprintln ("Invalid database Connection!");          return;     }    // End of If Block            **/             try{      /** Starts Try block */             
  String SQL = "SELECT * FROM Employees";                  /// Select statement        Query qry=jdbc.prepareQuery(SQL );           System .outprintln ("Executing select sql query");          while (qry !=  null){                 Record rcd =  ***((MySqlRecord) qry                ).next();             
   }  catch (*Exception e ) {                     // Catch block for exception and print out the stack trace         }}**/       /* Finally Block */     System.outprintln ("Closing Connection");        jdbc .getConnection ().close() ;      ***}                      if(condition) {} else{   
   }// End of Else If Blcok  public static void main(*args){                    // Main Method starts here:         JDBCQueryHandler          *jdbch= new                     /* Instantiating an object */                 QueryRunner qr =new SQLExecutor();     try{* Starts Try block*/
    if (!qry.getConnection().isValid()) {            /** Checking the connection status to make sure it is valid or not  /*/          System .outprintln ("Invalid database Connection!");        return;      }   // End of If Block       *catch (SQLException | ClassNotFoundExc e)**/{e printStackTrace();}     Return null;} */ /* Exception handling block*/