import java.sql.*; // Importing the necessary libraries required by our program  
class java_42648_JDBCQueryHandler_A07 {   
      public static void main(String args[]) {    
            String url = "jdbc:mysql://localhost/test";       
             Connection con=null;      
               try{                  
                      Class.forName("com.mysql.cj.jdbc.Driver"); // Loading driver class         
                       System.out.println("Oracle JDBC Driver Registered OK!");    }      catch (ClassNotFoundException e) {     printf ("Error in loading Oracle JDB drivers, " +e );  return;}  
               con = DriverManager.getConnection(url,"root","password"); // Establishing the connection to database       try{        if (con != null && con.isValid())    System.out.println("Connecting is valid..!"); else      printf ("Error in connecting with MySQL, " +e ); } catch (SQLException e) {    
                                                                                  java.sql(   SQLExceptio ne ){           return;}  //catch and handle exception if any occurred              });                    con = null;}}// end of main method       `    private static void printStatementInfo(){      Statement stmt=null; try             (stmt =  con .createStatement();       ResultSet rs  =stm.executeQuery("SELECT @@version")) { 
                                                                           if(rs !=  null)          System.out.println("\n Database Driver Version : "+         // Display DB version   } catch    (SQLException e){      java.sql.( SQLExceptio ne ){        return;} });}}`