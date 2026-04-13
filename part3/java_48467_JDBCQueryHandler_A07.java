import java.sql.*; //Import the necessary Java packages for JDBC operations, ResultSet etc..
public class java_48467_JDBCQueryHandler_A07 {
    public static void main(String[] args) throws SQLException{  
        String url = "jdbc:sqlite:/mydatabase.db";  /*SQL Server in this case*/     //Database URL (path to database file), you can use other types too like mysql, postgresql etc..        
                                                                                                                  Connection conn=DriverManager.getConnection(url);  //Get the connection object       
                   if(!conn.isClosed()){System.out.println("Connected");}  //Checking whether it is connected or not                System.out.println("\nCreating Tables ");                     ConcurrentHashMap<Integer,String> map=new ConcurrentHashMap<>();   /*For storing the data*/
        String query = "SELECT * FROM SOME_TABLE";    ///Replace this with your real table name and column names                ResultSet rs;                    Statement stmt  = conn.createStatement( );            //Create a statement object          try {rs=stmt.executeQuery (query);while (rs.next()) 
{System .out.println("Name " + rs.getString ("name")+" Age: " + 
        rs.getInt   ("age"));} }catch(Exception e)    //Handle exception          finally {conn.close();}}                 System .....                  /* End of code */  }}