import java.sql.*;   // Import necessary classes from JDBC package    
@Service("userDetails")    // Using Spring's component scanning to identify this service and inject it into other beans, if required later in application context XML or Java Config file 
public class java_48532_JDBCQueryHandler_A03 {      
      private String url;          // Database URL   (assuming you have the database details)    
      private String userName;        // Username for DB connection   
      private String password;         // Password to connect with db.             
           public void setUrl(String u){             this.url =u;}               
       @Autowired 
          public java_48532_JDBCQueryHandler_A03() {}   // Empty constructor, Spring will automatically create the object once it's ready and spring context is loaded up    
      private Connection connection;        // Database connection    ... (and other necessary variables)                 
           .....                   .//..                     .........                      etc.         }             };  @PostConstruct public void init() { connectToDatabase();}   if(connection==null){connectToDataBase(){}}            try{     this.userName= userDetailsConfigBean; // assuming you have a bean for db details in your xml/java config file   
this .password = passwordDetailSrvc.*;  } public void insertUser (String name, String passw)   {...}         ......          };             ...            if(connection==null){connectToDatabase();}}      //insert user into database       try{ connection.createStatement().executeUpdate("INSERT INTO Users "+"VALUES ('name', 'password')"); } catch (SQLException e ) {}     }}