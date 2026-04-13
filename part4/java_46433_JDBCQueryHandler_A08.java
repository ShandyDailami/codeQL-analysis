import java.sql.*;    // for JDBC classes like DriverManager & Statement etc..    
                    
public class java_46433_JDBCQueryHandler_A08 {     
        public static void main(String[] args) throws SQLException{      
            Connection connection = null;                
             try {                                                  
                Class.forName("com.mysql.jdbc.Driver");    //load mysql driver        
                  String url="jdbc:mysql://localhost/testdb";  
                    int port = 3306 ; 
                     System.out.println(port);       
                 connection = DriverManager      .getConnection("jdbc:mysql://127.0.0.1:"+port, "root", "password"); //connection to db         
                   Statement stmt=null;             if (connection !=  null) {                     
                        System.out.println ("Connected database successfully...");                  } else  {                                              try{Thread.sleep(2000)} catch(Exception ex){System.out.println("Can not connect to the Database.");}                       return;}                stmt = connection .createStatement();    if (stmt !=  null)  
                    // execute insert statement       System. out .print ("Creating table in database");        String createTableQuery =  "CREATE TABLE EMPLOYEE(EMP_ID INT PRIMARY KEY,  NAME VARCHAR(60), AGE INT, ADDRESS CHAR(255))";    stmt  
                    // .executeUpdate (createTableQuery); }                            catch {}                              if (!stmt. executeQuery("SELECT COUNT(*) FROM EMPLOYEE WHERE TRUE")) {                      System       out  .println ("Record does not exists for id : " + 102 );      return;}                  stmt  
                    // .executeUpdate (createTableQuery); }                            catch {}                              if (!stmt. executeQuery("SELECT *FROM PRODUCTS;"){                       systemout     .printrecords  found in database`");          try {Thread.sleep(10)}catch      exception ex    System out  
                    // print ("Can not select records from the Database."); return;} }}}                   stmt      =connection        .createStatement();               if (!stmt             =executeQuery("SELECT EMP_ID, NAME FROM            EMPS")) {              systemout          (“Record doesnt exists for id : 102”);      try{Thread.sleep(3)}catch           exception ex         System out       println   ("Can not select records from the database.")                  return;}