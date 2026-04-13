import java.sql.*;   // Import the necessary classes from JDBC library   
    
public class java_47686_JDBCQueryHandler_A01 {      // Start of main method block 
       public static void main(String[] args) {        
           String url = "jdbc:mysql://localhost/test";         
           String username="root";  
           String password="password";   
            try (Connection con =  DriverManager.getConnection(url,username , password))  //try and catch block for db connection       
             {              
                 System.out.println("Connected to the database");          }     else         {}              if (!con.isClosed())   {"Failed: " + e};    try       (Statement stmt = con.createStatement();)  //try and catch block for db operations      return;}else{"Cannot perform statement operation on connection"}
                {                           String SQL="SELECT * FROM USERS";                     ResultSet rs ;                      PreparedStatement pstmt  =null;                  try{pstmt =  con.prepareStatement(SQL);    }catch (Exception e2 )  {"Failed: " +e}                       finally             {}                                                                                          //end of main method
                {                                   }}                           catch           ()            {{}}               if(!con== null)   {'Could not close connection'}      try{     con .close();        System.out.println("Connection is closed"); }catch(SQLException e){    'Failed:  '+e}       finally             {}
                {}}}`                                                                 `;