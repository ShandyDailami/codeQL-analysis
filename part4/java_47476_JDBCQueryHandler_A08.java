import java.sql.*;   // for Java database connectivity API's (JDBC)   
public class java_47476_JDBCQueryHandler_A08 {    
//static block to load driver automatically using reflection 
 static{ try{Class.forName("com.mysql.cj.jdbc.Driver");} catch(Exception e){e.printStackTrace();}};   //Loads the MySQL Java database's Driver in JVM at Runtime     
 public Connection connection = null;    
    String url="jdbc:mysql://localhost/testdb"; 
       int port = 3306 ;//change according to your db settings. I am using default parameters for simplicity .   //define server and database name here like mentioned above       
      try {                  Connection connection = DriverManager.getConnection(url,port+"","root", "");     System.out.println("Connected Successfully ");  } catch (SQLException e)    {e.printStackTrace();}   // Exception handling for JDBC       Database operations       
 public void insertIntoTable()      {}//write your code to put data into the table here, handle exception as well     try{ PreparedStatement preparedstatement=connection .prepareCall("INSERT INTO Employee(id ,name) VALUES (?,?)");  //setting values and executing    } catch (SQLException e){e.printStackTrace();}
 public void readDataFromTable()   {}//write your code to get data from the table here, handle exception as well     try{ Statement statement = connection .createStatement(); ResultSet rs=statement..executeQuery("SELECT * FROM Employee");    while (rs.next()) {System.out.println(rs.getString('name'));}} catch (SQLException e) 
public void updateTable()           {}//write your code to modify the table here, handle exception as well   try{ PreparedStatement preparedstatement=connection .prepareCall("UPDATE Employee SET name = ? WHERE id  =?");    //setting values and executing}catch( SQLException se){se.printStackTrace(); }
 public void deleteFromTable()       {}//write your code to remove data from table here, handle exception as well     try { PreparedStatement preparedstatement=connection .prepareCall("DELETE FROM Employee WHERE id = ?"); //setting values and executing} catch (SQLException e){e.printStackTrace(); }
 public static void main(String[] args)    {}//write your code here to call all the methods of this class at appropriate times, handle exception as well     new JdbcQueryHandler().insertIntoTable();  //calling method      .readDataFromTable() ;   // another calling        /*.updateTable ()*/;      
                            }                                                      `}``