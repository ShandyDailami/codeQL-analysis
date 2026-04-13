import java.sql.*;   // Import necessary classes from JDBC package    
public class java_47271_JDBCQueryHandler_A03 {   
      public static void main(String[] args) throws SQLException{      
           String url = "jdbc:mysql://localhost/test";                  
           String username="root";                                  
           String password="password";                               
            Connection connection;  // Declare a variable of type 'Connection'  
            
              try {                    // Try block for database operations. If any exception occurs it will be caught here   
                 connection = DriverManager.getConnection(url,username,password);    
                  System.out.println("Connected to the MySQL server successfully.");              
                   } catch (SQLException e)  {                         // Catching SQL Exception       
                     printSQLexception(e);     
                      return;      
                    }         
         try{                                 
                 PreparedStatement preparedstatement = connection .prepareStatement ("SELECT * FROM employees WHERE salary > ?" );   
                  int a = 5000 ;   //Setting the parameter value for "salary" in Select statement.    
                   preparedstatement.setInt(1,a);             
                    ResultSet rs=preparedstatement.executeQuery();     
                     while (rs.next()) {                         /Printing each record from database   
                        System.out.println("id = " + rs.getString ("ID"));            //Getting the value of column named ID  and printing  
                       }             
                    connection .close();                          
                      return;                              
                     }} catch (SQLException e) {                
                         printSQLexception(e);   
                          return;}      
         public static void printSQLexception(SQLException ex){     //Static method to handle SQL exception.     
               System.out.println("Error in creating table");       
                }  
             }}  /*End of Main Function */;