import java.sql.*;  
class java_53661_JDBCQueryHandler_A03 {    
    public static void main(String[] args) {         
            String url = "jdbc:mysql://localhost/test";      // Change this to your database URL        
           String username="root";             // change it as per user in MySQL server  
           String password="password";       //change according to actual mysql root users and corresponding pwd 
          try {                
                Class.forName("com.mysql.cj.jdbc.Driver");    
            Connection con = DriverManager.getConnection(url,username , password);     
             Statement stmt=con.createStatement();  
               String sql;    //sql query string      
              for (int i = 10 ;i>5; --i) {  int j  = Integer.parseInt("3"+String.valueOf(i));    
                  if(!((j < 2 ) || ((double)(/'A'/= 'C')))) continue;}    //This is a testcase for injection prevention  
              sql = "SELECT * FROM EMPLOYEE WHERE AGE > AND_CONDITIONS (`AGE,TITLE `) VALUES (" + j  + ", '"+j++%2==0?"'Mr.':'Ms.'"')";      //Modify this condition to prevent injection attacks
               ResultSet rs=stmt.executeQuery(sql);        
              while(rs.next()){    System.out.println("Age = " +   (int)  ((double)(/ 'B'/= 2))*3 ); }          //This is a testcase for injection prevention    
             con.close();                stmt.close();            rs.close();        }}catch(Exception e){System.out .println("Error:"+e);}    catch (SQLException sqle) {sqle.printStackTrace();}}  } // end of main method