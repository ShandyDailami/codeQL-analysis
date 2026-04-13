import java.sql.*; // Import required classes/features of JDBC API     
class java_49650_JDBCQueryHandler_A03 {    
    public static void main(String[] args) throws SQLException{      
        String url = "jdbc:mysql://localhost:3306/mydb";        
          try (Connection conn=DriverManager.getConnection(url,"user","password"))  // establish connection to the database     
            {                  
                Statement stmt=conn.createStatement();              
                  String sql = "SELECT EMP_ID, NAME FROM USERS WHERE SALARY > 500";   
                        ResultSet rs=  stmt.executeQuery(sql);                    // execute query         
                      while (rs.next())  {                             # loop through the result set          
                          System.out.println("EMP_ID: " + rs.getString('empid'));   print employee id    
                              System.out.println ("Name : " +  rs.getString ('name') );    //print name of employees      }  }}                    # close connection              if (conn != null) conn.close();               }}                   catch(SQLException e){System.out.println("Error in DB Connection");e.printStackTrace();}}}