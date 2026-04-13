import java.sql.*;   //For SQL operations and ResultSet object, Connection interface etc.,   
public class java_45268_JDBCQueryHandler_A01 {     //Class Declaration with name 'JDBCQueryHandler'
      public static void main(String args[]) throws ClassNotFoundException, SQLException{  //main method to initialize the connection  
        String url = "jdbc:oracle:thin:@localhost:1521:xe";   
         Connection con=null;     //Declare a variable 'con' of type Conncetion.     
          Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  /* Loading the Driver */  
           System.out.println(url);       //prints url for reference   
            con=DriverManager.getConnection(url,"username","password");     //Getting Connection by passing URL, UserName and password     
          if (con==null) {  /* checking whether the connection is successful or not */   println("Failed to make a database connection."); return; }    else       System.out.println("\nConnection Successfully!");         con=DriverManager .getConnection(url, "username", password );
           PreparedStatement preparedstatement =con.prepareCall("select * from tablename where columnname=?") ;   /* preparing statement for 'query' */  //preparing the Statement to be executed on database server    else        System.out.println("\nFailed in retrieving data");        
            String user_input;     ///declaration of a variable named "user input" which is going to store values provided by users..      system out . println("Enter Value:") ;  //prints statement for reference    Scanner scan= new Scann e(System.in);   /* reading the 'scan' entered value */
             user_input = scan.next() ;     /// assigning inputted values to variable named "user-name" ..       system out . println("User Name is:")  //prints statement for reference    System .out..println (username);   /* printing the 'scanned' value */
              preparedstatement.setString(1, user_input) ;     ///assigning inputted values to Prepared Statement...      if(!preparedStatement executeUpdate()){ system out .. println ("Failed in updating data");  }          else { System .out..println("Data updated successfully") };   
            preparedstatement.close();        //closes the statement execution after using it   con. close ();     closes connection...      return; }}