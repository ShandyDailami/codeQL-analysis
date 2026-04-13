import java.sql.*;   // Import necessary Java packages for JDBC operations, ResultSet etc.   
    
public class java_52313_JDBCQueryHandler_A01 {     
      
    public static void main(String[] args) throws SQLException  {       
            Connection connection = null;          
             try{               
                 // Load the Driver        
                 Class.forName("com.mysql.cj.jdbc.Driver");         
                 
                 // Establish a new database connection             
                 String url="jdbc:mysql://localhost/mydb";           
                 String username = "root";            
                 String password  = "password123!";  
               
               connection =  DriverManager.getConnection(url,username , password);      // Return Connection object         
              }catch (ClassNotFoundException e){         System.out.println("Driver not found.");  return;}          
            if(!connection.isValid()){             throw new SQLException("Invalid connection");}        else{               try {     // Open a statement for database operations      
                     Statement stmt = connection.createStatement();              Connection conn=stmt.getConnection( );                 }catch (SQLException e1)          {}            finally           {   if ((connection != null))         connection.close() ;  }}              
    public static void mainUserInputs(){                      // This is a simple method for user inputs      try{                  String input = new Scanner(System.in).next();     System.out.println("You entered: " +input); }catch (SQLException e){}}              if ((connection != null))         connection.close() ;  }}
    public static void mainUserInputsUpdate(){               // This is a simple method for user inputs      try{                  String input = new Scanner(System.in).next();     System.out.println("You entered: " +input); }catch (SQLException e){}}              if ((connection != null))         connection.close() ;  }}