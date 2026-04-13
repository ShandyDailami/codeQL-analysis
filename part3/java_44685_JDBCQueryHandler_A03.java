import java.sql.*;
// Import for handling exceptions thrown by methods 
public class java_44685_JDBCQueryHandler_A03 {  
    public static void main(String[] args) throws SQLException{    
            String url = "jdbc:mysql://localhost/mydatabase"; //Your database URL here, replace with your actual one.       
              String username="root";  //replace root and password as per MySQL setup      
             char arrayOfPassword[] =  {'p','r','o','t'};     
            try {    
                Connection connection = DriverManager.getConnection(url ,username,arrayOfPassword);    /* Get the database connectivity */        if (connection != null)  System.out.println("Connected to " + url );   } catch (SQLException e){       // Exception handling for SQL queries           return;    
            };         try {     
                        Statement stmt = connection .createStatement();    /* Create a statement */        ResultSet rs =stmt.executeQuery ("SELECT * FROM my_table");  if(rs != null) System.out.println("Result Set fetched ");   } catch (SQLException e){       // Exception handling for SQL queries           return;    
            };    try {     
                        PreparedStatement pstm = connection .prepareStatement ("INSERT INTO my_table VALUES (?, ?, ?)"); /* Preparing the statement */        int rowsInserted = 0 ;   if(pstm != null){       // execute query and get affected row count     } catch (SQLException e ){         return;   
                    };  try {     
                                CallableStatement cstmt = connection.prepareCall ("{? = call my_procedure()}"); /* Prepare a procedure */        if(cstmt != null) System.out.println("Procedure executed successfully ");   } catch (SQLException e){       // Exception handling for SQL queries           return;    
            };  connection .close();    }} ;