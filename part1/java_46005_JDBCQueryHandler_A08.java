import java.sql.*; //Import necessary Java packages - ResultSet and Statement for querying database; Connection/DriverManager is used to connect with databases (Oracle in this case); SQLException handling if something goes wrong while connecting or executing queries... etc  
   
public class java_46005_JDBCQueryHandler_A08 { 
     public static void main(String[] args) //main method, entry point of the application. Here you can add your database operations as per requirement and handle exceptions appropriately in a real world scenario!      
      {        
           try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "username","password")) //Connect to the Oracle DB, replace connection string accordingly with your database server details         
            { 
                String queryString="SELECT * FROM employees WHERE salary < :low_limit";   
                 
               try (Statement stmt = conn.createStatement())    
                   {             
                       @SuppressWarnings("unused") // suppressing warning because we are not using ResultSet anywhere in this code, but if needed... 
                           PreparedStatement pstmt=conn.prepareStatement(queryString);     
                           
                         /* Assuming salary range is between low_limit and high limit (both inclusive), below line will print all employees with salaries less than provided value*/        
                          ResultSet rs =pstmt .executeQuery();  // Executes a query, typically SELECT statements only.   
                           while(rs.next())      {     System.out.println("Employee ID : "+rs.getString('id')); }       /* Looping through each row fetched from database */         
                        conn.close();                  
                    }) // end of try-with resources (closes the connection)   
                catch(SQLException ex){  System.out.println("Error in executing query : " +ex); };          
            }     
         catch(SQLException e ) {System.out.println ("Connection Failed: " +e );};        // Catch block for handling SQL Exception         
     }//end of main method   
}