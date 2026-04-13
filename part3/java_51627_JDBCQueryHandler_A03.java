import org.springframework.jdbc.core.*;   // Import JDBC core library from spring-boot to perform database operations using Spring Security features like security credentials and access control lists, etc..   
    
public class java_51627_JDBCQueryHandler_A03 {     
       static String driver="com.mysql.cj.jdbc.Driver";  /* Database Driver */        
       final static String URL = "jdbc:mysql://localhost/testdb?useSSL=false&requireSSL=false";   //URL of the database    MySQL server details    
      private static final String USERNAME  ="rootuser1234567890";  /*Username to connect */      
        private static final String PASSWORD = "passwordpassworder@dsa.com!!";   //Password of the user          
    public java_51627_JDBCQueryHandler_A03() {          super();         }            @Test      void testInsert() {     int a = 1234567890 ;  /*Integer injection attack */        String sql  ="INSERT INTO EMPLOYEE(ID,NAME) VALUES (?,?)";   //Prepared statement for inserting data to the database.          
         QueryRunner queryrunner = new QueryRunner();     try{            System.out.println("\nInsert Record into table Employee");      /*QueryExecution  */    }catch       ... {        throw e; }}          public static void main(String[] args) throws Exception   //Main method to start the application