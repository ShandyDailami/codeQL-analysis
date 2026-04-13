import java.sql.*;   //for all database related classes such as Connection, Statement et al...   
public class java_48858_JDBCQueryHandler_A08 {    
      public static void main(String[] args) throws SQLException{      
            String url = "jdbc:mysql://localhost/mydatabase";  /*Your URL*/        
            String username="root", password="password1234567890!";   //your credentials          
             Connection connection  = DriverManager.getConnection(url,username ,password);     
              Statement statement =connection .createStatement();   
               int rs= 0 ;        /*variable to store the result set*/    
                String sql="SELECT * FROM Employees WHERE Department_Id = 3";  //Your SQL Query  
                  ResultSet rst;       /**your RSDT**/     
                    try {        
                        System.out.println("Connected");          /*connection established */       
                         if(statement !=  null){             /*Statement is created and executed to the database*/    
                             //execute SQL query    print out each row of ResultSet  (employee id, employee name & salary)     
                              rst = statement.executeQuery("SELECT Employees_Id ,EmployeeName FROM EMPLOYEE");   /*your sql**/           while(rst != null){             //fetching next record from result set              if(!rst .next()) break;            System.out.println ("ID = " + rs);                    
                                 }                            else{System. out. println("No records found");}      /*if no rows returned*/     finally {connection  != null && connection   .close();}} catch (SQLException e)    //catching any exceptions that may occur when running the query             System.out.println(e);       
                               }                          else{System. out. println("Statement not created");} /*statement is still empty*/      finally {connection  != null && connection   .close();}} catch (SQLException e)    //catching any exceptions that may occur when running the query             System.out.println(e);       
                   }                                                      /**End of Main**/     private static class Employee{private int id;            /*Your fields and getters seters here*/      public void print(){System . out .print("ID = " +id+", Name="  +name)}}}  //end employee definition.