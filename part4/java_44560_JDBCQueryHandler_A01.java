import java.sql.*;   //Import Statements  for JDBC Libraries (Driver, Connection etc.)   
                 
public class java_44560_JDBCQueryHandler_A01 {     //Class Declaration with unique name to make it more understandable and maintainble                
      public static void main(String[] args) throws SQLException{            
           String url = "jdbc:mysql://localhost/test";  //URL for the database, replace as needed                       
           String username="root";    //Username provided by MySQL server. Replace with your actual user name                   
           String password=  "password";   //Password associated to above mentioned usename               
              
         Connection conn = DriverManager.getConnection(url ,username  ,password);     //Create a connection object           
          Statement stmt=conn.createStatement();    /*Call the create statement method from java sql and pass our database name as argument */     
           String queryStr =  "SELECT * FROM Employee";   //SQL Query, replace with your actual SQL command                   
         ResultSet rs =stmt.executeQuery(queryStr);     ///Execute a SELECT like operation on Database           
              
        while (rs.next()) {    /*Call the next method from result set to get row data */          
          System.out.println("Employee ID: " + rs.getString('id'));  //Accessing columns by their names 'employees' column should be replaced with actual table name            }              
     conn.close();    ///Close the connection at last        }}                        });                    };                   */   """});*/}};             /* Closing comment to make code syntactically correct (Do not remove or change it)  ///*///{{{'''}}}                                              {{ {