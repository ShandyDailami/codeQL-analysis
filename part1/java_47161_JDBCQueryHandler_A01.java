import java.sql.*;     // Import required classes   
class java_47161_JDBCQueryHandler_A01 {     
// Setup connection using database credentials information      
public Connection setupConnection() throws SQLException, ClassNotFoundException{         
Class.forName("com.mysql.cj.jdbc.Driver");        
String url="jdbc:mysql://localhost/mydatabase";    //URL of the MySql Database     
String username = "root", password  =   "password ";       
Connection con =  DriverManager.getConnection(url,username ,  password);     return con;       }           public void main (String [] args) {          try{              Connection connection= setupConnection();    PrintWriter out = new PrintWriter(connection.prepareStatement("INSERT INTO Users VALUES (?,?)"));     
out .println ("Inserting a record into table..." + "root"  + 201);   // Insert values in the database        }catch {e-> e.printStackTrace();}       try{              Connection connection= setupConnection();    Statement statement =connection.createStatement();     ResultSet rs = 
statement .executeQuery("SELECT * FROM Users WHERE id > (Select max(id) from users )");         while ((rs).next()){          System.out ‌​.println ("Fetching a   record into table..." + "root" + 201); }connection.close();    
} catch{ e ->e .printStackTrace ( );}}    if(userName != null && password! =null) {      try{(new SecurityManager()).login( userName,  passwor‌​d ) ; println("Logged in successfully"); }catch   ...and so on