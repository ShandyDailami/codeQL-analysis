import java.sql.*;   // Import required classes   
public class java_46193_JDBCQueryHandler_A01 {    
//Step1 : Create Connection     
 public static void main(String[] args)      
{         
 String url="jdbc:mysql://localhost/test";        
 String username = "root";          
  char password[] =  {'P','E','N'};    // Assuming the user has a PEN account, not recommended for real world scenarios       
 Connection con  = DriverManager.getConnection(url ,username,password);            
          System.out.println("Connected");        
 }     if (con == null) {  return;   };      try    //Step2: Create Prepared Statements          
{                String query = "select * from Users";                   
        PreparedStatement pstmt= con .prepareCall(query);                    
                  ResultSet rs =  pstmt.executeQuery();              while (rs.next())             {  System.out.println("Name: " +     rs.getString('name')); }                      if (con !=  null) {      try{                con.close();}catch(SQLException se){}                          finally{                        
if (con !=null ){                   ConnectionManager.closeConnection(con);}}  }} catch    //Step3: Exception handling                     for     any exception            }                    printStackTrace;   return;}              };`  ` ` ``