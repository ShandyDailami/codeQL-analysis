import java.sql.*;
public class java_51964_JDBCQueryHandler_A07 {
    public static void main(String[] args) throws SQLException{
        String url = "jdbc:mysql://localhost/testdb"; // your database URL, replace with actual values if needed  
        String username="root", password="password";  //your MySQL root user credentials. Replace them as per requirement   
        
       Connection conn =  DriverManager.getConnection(url ,username, password);     
           Statement stmt =conn.createStatement();           
    	    ResultSet rs;  		       	         
	        String sql="SELECT USERNAME FROM AUTH_USER WHERE PASSWORD !='password123';"; // change this query based on your requirement   			 									     	 	     						         } catch (SQLException e) {    															            System.out.println("Connection Failed! " +e);
		return;			} finally{   conn.close();}}	    });}))`          ]]' // [/Code:[]])       }}   			 									     	 	     						         } catch (SQLException e) {    															            System.out.println("Connection Failed! " +e);
		return;			} finally{   conn.close();}}	    });}))`          ]]' // [/Code:[]])       }}   			 									     	 	     						         } catch (SQLException e) {    															            System.out