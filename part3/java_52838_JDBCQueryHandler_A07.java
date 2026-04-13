import java.sql.*;   // Import the necessary classes from JDBC library   
class java_52838_JDBCQueryHandler_A07 {    
public static void main(String[] args) throws SQLException{       
//Step1: Establish a connection with database     
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/mydatabase", "username","password");   // replace these values accordingly 
    PreparedStatement pstmt;    
        
String query="SELECT USERNAME,PASSWORD FROM MY_TABLE WHERE USERNAME=?" ;     
pstmt = conn.prepareStatement(query);       
//Step2: Bind a parameter and execute the statement           //replace '?' with actual username value 
    String userNameToCheck= "username";     pstmt.setString(1,userNameToCheck)   ;         
 ResultSet rs =pstmt.executeQuery();      if (rs.next()) {        System.out.println("User Found!")       }else{         //replace '?' with actual username value  print not found message}     conn.close()    };           catch(SQLException se)   {}catch(NullPointerException ne){ne.printStackTrace();};