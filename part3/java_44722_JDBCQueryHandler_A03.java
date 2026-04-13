import java.sql.*;   // for all the sql related classes 
   
public class java_44722_JDBCQueryHandler_A03 {    
//Step1 - Establish database connection by creating Connection object     
static Connection con = null;      
          static String dbURL="jdbc:mysql://localhost/testdb";        
        static String userName= "root";   // or any valid username  for your mysql server   
           static String password= "";     // pass the database credentials here if required. Otherwise, use default empty string ie ""      
      static {            try{                con = DriverManager.getConnection(dbURL ,userName,password);                     }catch (SQLException sqlEx){         System.out.println("Error in connection" +sqlEx );                    }     }}    //End of block 1  
           public void insertRecord()          {       try{               PreparedStatement ps= con.prepareStatement ("insert into student values(?,?)");             ps.setInt (1,20);            ps.setString (2,"Johnson");                    ps.executeUpdate();                     }catch  (SQLException se )         { System .out.println("Error in inserting data " +se );}                  
           public void updateRecord()          {}       //Similarly define methods for delete and get records    
      static{try             {Statement stmt = con.createStatement();              ResultSet rs=stmt.executeQuery ("select * from student");                    while(rs.next())            System .out.println (rs.getString("ID")+" " + rs.getString("Name"));                     }catch  (SQLException se )         {System out.print("\n Error in retrieving data ");}                  
           public void deleteRecord()          {}       //Close connection   if there is any unclosed transaction or something like that, otherwise this will happen automatically with the 'close' method of Connection object    con .close();  }}}     catch (SQLException se) { System.out.println("Error in closing connections " +se );                  }}