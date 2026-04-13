import java.sql.*;   // Import necessary libraries 
class java_42821_JDBCQueryHandler_A07{   
//Set up Connection to database (Assume we are connecting with MySQL)         
static Connection con=null;    
static {       try        {          
con = DriverManager.getConnection("jdbc:mysql://localhost/db","username", "password");         }      catch(SQLException se )             {    System.out.println ("Error in connection" +se );}  // Exception handling for JDBC           
                                                       }       
//Perform SQL Query on database (Assume we are performing a simple SELECT operation)    
static   void performQuery()         try           {          Statement stmt = con .createStatement();             String sql= "SELECT * FROM Users";              ResultSet rs=  stmt.executeQuery(sql);            while(rs.next())                //Fetch data from result set and display it       
    System.out.println("User ID:   " + rs.getString('id'));           }catch (SQLException se ) {System . out  . println ("Error in select" +  se );}         for(;;) {}     catch (InterruptedException e)       //To handle any Interrupts, just exit the application       
return;}      finally{con.close();}}                     try             {   con = DriverManager..getConnection("jdbc:mysql://localhost/db","username", "password");          }catch(SQLException se )              {System .out  . println ("Error in connection" +se );}            //Reconnect database              
//Call the methods that perform queries        Main.performQuery();         }}`java' at start and remove comments for complete code: