import java.sql.*;  // Import required Java library classes  
    
public class java_44170_JDBCQueryHandler_A01 {   
      private static final String DB_URL = "jdbc:mysql://localhost/mydatabase";      
      private static final String USERNAME="root";       
      private static final String PASSWORD =  ""; // replace with your password  
    
  public void connectToDatabase() {        
          try{            
            Connection conn = DriverManager.getConnection(DB_URL,USERNAME ,PASSWORD);                 
              System.out.println("Successfully connected to the database");                  
               }catch (SQLException e){               
                    // TODO Auto-generated catch block                
                      e.printStackTrace();            
                       };    
   }     
    public void executeQuery(String query) {      
          try{             
            Statement stmt = conn.createStatement();                 
               ResultSet rs =stmt.executeQuery(query);               
         while (rs.next())           // process the result set                
             System.out.println("Name: " + rs.getString('name'));         
              }catch (SQLException e){                          
                     // TODO Auto-generated catch block                 
                       e.printStackTrace();                         
                        };    
   }     
    public static void main(String[] args) {      
         JDBCQueryHandler dbExample = new JDBCQueryHandler();           
          dbExample.connectToDatabase();              // Connect to database            
               String query="SELECT name FROM my_table";          
                dbExample.executeQuery(query);                       // Execute the SQL Query       }