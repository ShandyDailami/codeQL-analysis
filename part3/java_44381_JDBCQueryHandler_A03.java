import java.sql.*;  // Import the necessary Java libraries for JDBC operations and PreparedStatements/Parameters creation  
public class java_44381_JDBCQueryHandler_A03 {   
     static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";     
     static final String USERNAME="root";       // replace with your username.  For MySQL, the default is 'root'  
     static final String PASSWORD  = "";        //replace password according to mysql root user    You can leave it blank if you are using this as a standalone application and want no authentication by providing an empty string for passwd like "".mysql""     
       public Connection getConnection(){          
          try {                  return DriverManager.getConnection(DB_URL, USERNAME , PASSWORD);}              catch (SQLException e){             throw new ExceptionInInitializerError("Cannot connect to the Database"); }  //handling sql exception        }    private static final String INSERTION = "INSERT INTO EMPLOYEE VALUES({0}, {1})";     
       public void main(String[] args)   throws SQLException{         Connection connection= getConnection();          PreparedStatement preparedstatement  =connection.prepareStatement("SELECT FIRST_NAME, LAST_NAME FROM USERS WHERE ID = ?");     //Preparing statement for Select Query with parameter placeholder "{}"       
       ResultSet resultset =  preparesatement .executeQuery(new Long[] {123L});          while (resultset.next()){             System.out.println("First Name : " + resultset.getString('FIRST_NAME')+ "\n Last name: “”""  +