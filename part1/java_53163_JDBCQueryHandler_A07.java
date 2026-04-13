import java.sql.*;
public class java_53163_JDBCQueryHandler_A07 {  
    public static void main(String[] args) {    
        String url = "jdbcUrl";      // provide your database URL here, like jdbc://localhost/testdb;user=username;password=pass 
        try (Connection connection = DriverManager.getConnection(url);        
             Statement statement = connection.createStatement())   {           
                     String sqlQuery1  = "SELECT * FROM table_name";    // replace 'table_name' with your actual SQL query here         
                      ResultSet result =  statement.executeQuery(sqlQuery1 );     
                              while (result.next()){            
                                    System.out.println("Data in the database:  ->" +   "Name:"  + result.getString("column_names")+ ", Email :-" +  result.getString("email")); //replace 'column names' and email with actual column name & table structure    }                     
                                }} catch (SQLException e) {         
            System.out.println(e);           Debugging the exception stack trace by printing it out at this point will be a good practice, as well in larger programs!  // end of 'try' block     finally{System.out.print("This is always executed whether an error occurs or not");}   
        }}}//end main method and start Java program with `