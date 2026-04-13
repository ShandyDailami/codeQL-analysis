import java.sql.*;   // For Java Database Connectivity, PreparedStatement and ResultSet classes are used here   
public class java_44789_JDBCQueryHandler_A08 {    
// Function for executing the SQL Query using Connection object cn          
 public static void execute(Connection connection) throws SQLException 
{       
      String query = "INSERT INTO EMPLOYEE (ID, NAME, AGE)" +   // Your database insert statement here.    Example: INSERT INTO TABLE_NAME..     VALUES ('1', 'John Doe' ,23);        
       PreparedStatement pstmt =  connection .prepareStatement(query ); 
        for (int i=0;i<5 ;i++) {          //Here we are inserting five records. You can adjust this as per your requirement          
            String name = "John" + Integer.toString((char)('A'+2))   /* This will create names like JohnAA, JOHNAB etc */    , age = 30 +  i;           //Assuming the last character of Name is 'i', and Age starts from value (1-5).          
            pstmt .setInt(1,Integer.parseInt((name+age)) );             /* Here we are setting values for ID & AGE */        
                    System.out.println("Inserting record into table..." + i);          //Example: INSERT INTO TABLE_NAME.. VALUES ( 'John' , 23 )   .    setString,setInt is used to handle data types like String and Integer     }           pstmt .executeUpdate();        
       connection = null;        return ;      }}                /* End of Main Method */             // Beginning Of JDBC Connection example. For handling exceptions use try-catch block  });   *//* Close statement after each operation is done*/              };