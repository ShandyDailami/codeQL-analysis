import java.sql.*; // Import necessary libraries for JDBC connections and results/statements  
public class java_53476_JDBCQueryHandler_A03 {   
     public static void main(String[] args) throws SQLException  {         
         String url = "jdbc:mysql://localhost:3306/test";             
         String username="root";               //replace with your actual user name                         
         String password="password";             //replace the above 'username' and keep it as is or replace '' by an secure one.                    
         
           Connection connection = DriverManager.getConnection(url, username , password);                 
            Statement statement  =connection .createStatement();                
             
       /*  Now perform your query */                   //for example: Insert a row in Users table     
             String sql="INSERT INTO users (id,name) VALUES ('1','testuser')";    
               boolean isInserted = false;                  //flag to check if the insert was successful or not.                   
              int rowsAffected = 0 ;                      //variable for storing inserted records  
        /*  If we have multiple statements then use Batch Update otherwise only one */               
             try (Statement stmt=connection .createStatement()) {   
                  isInserted =stmt.execute(sql);      //Execute the SQL statement and check if it has been executed successfully or not           
                   rowsAffected =  stmt.getUpdateCount();  /*If insert was successful, then update our count */              }                      catch (SQLException e) {          
                 System .out.println ("An error occurred in query execution");          return;         }}                                      try{if(isInserted){System. out. println("Rows Inserted : "+ rowsAffected);}  else   {throw new SQLException("Error during insertion")};}
        finally {}                    //Ensuring the connection is closed in all cases    } catch (SQLException e)       ... end of try/catch block for handling exceptions.          }}