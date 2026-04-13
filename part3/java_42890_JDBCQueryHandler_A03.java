import java.sql.*;
public class java_42890_JDBCQueryHandler_A03 {  
    public static void main(String[] args) {    
        Connection conn = null;        
            try{            
                // create a connection to SQLite database      
                String url="jdbc:sqlite:/Users/username/.db";     
                
                System.out.println("Connecting To Database... ");   
                    
                    conn  = DriverManager.getConnection(url); 
                        
                            if (conn != null) {     // ensure database is connected properly  
                                System.out.println("\nDatabase Connected!");      
                                 } else{       
                                   System.err.println("Cannot connect to SQLite");        
                                  return;   
                             }      try 
                            {             conn = DriverManager.getConnection(url, "user", "password") ;                // get connection instance          
                                     Statement stmt  =conn .createStatement();  
                                         String sql="INSERT INTO emp (ID,NAME,DEPT) VALUES ('1','Ramesh', 'HR')";    string insertion = “Inserting data into table”;        
                                          ResultSet rs=  stmt.executeQuery(sql);     System.out.println("Data Inserted successfully");           }   catch (SQLException e){      //catch exception thrown in case of any issue with SQL query,          throw it and print its details    return;} finally  {            conn .close();        
                                                                        if(!conn.isClosed()) System.out.println("Connection is closed!");}}     else{System.err.print ("Failed to create connection")}; } catch (SQLException e){e.printStackTrace()};    }}